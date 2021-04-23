package leetcode.decide;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * @author QiuHongLong
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // 此场景
        // 是深度遍历（递归决策）
        // 而不是广度遍历（bfs）
        List<Character> state = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    state.add(board[i][j]);
                    board[i][j] = '@';
                    List<List<Integer>> nextOpts = buildNextOpts(board, word, state, i, j);
                    if (doExist(copy(board), word, state, nextOpts)) return true;
                    board[i][j] = word.charAt(0);
                    state.remove(state.size() - 1);
                }
            }
        }
        return false;

    }

    public boolean doExist(char[][] board, String word, List<Character> state, List<List<Integer>> opts) {
        if (opts.size() == 0)
            return word.length() == state.size();
        boolean result = false;
        for (List<Integer> opt : opts) {
            int x = opt.get(0);
            int y = opt.get(1);
            char c = board[x][y];
            state.add(board[x][y]);
            board[x][y] = '@';
            List<List<Integer>> nextOpts = buildNextOpts(board, word, state, x, y);
            result = doExist(copy(board), word, state, nextOpts) || result;
            state.remove(state.size() - 1);
            board[x][y] = c;
        }
        return result;
    }

    private char[][] copy(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    private List<List<Integer>> buildNextOpts(char[][] board, String word, List<Character> state, int x, int y) {
        List<List<Integer>> nextOpts = new LinkedList<>();
        if (word.length() == state.size()) return nextOpts;
        char c = word.charAt(state.size());
        if (x - 1 > -1 && board[x - 1][y] != '@' && board[x - 1][y] == c)
            nextOpts.add(Arrays.asList(x - 1, y));
        if (x + 1 < board.length && board[x + 1][y] != '@' && board[x + 1][y] == c)
            nextOpts.add(Arrays.asList(x + 1, y));
        if (y - 1 > -1 && board[x][y - 1] != '@' && board[x][y - 1] == c)
            nextOpts.add(Arrays.asList(x, y - 1));
        if (y + 1 < board[0].length && board[x][y + 1] != '@' && board[x][y + 1] == c)
            nextOpts.add(Arrays.asList(x, y + 1));
        return nextOpts;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(
                new char[][]{
                        {'c', 'a', 'a'},
                        {'a', 'a', 'a'},
                        {'b', 'c', 'a'}
                }, "aab"));
    }

}
