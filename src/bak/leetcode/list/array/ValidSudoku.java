package bak.leetcode.list.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独中，已经填入的数字是否有效。
 * 只需要根据以下规则，
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author QiuHongLong
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] cols = new Set[board.length];
        Set<Character>[] rows = new Set[board.length];
        Set<Character>[] boxes = new Set[board.length];

        for (int i = 0; i < board.length; i++) {
            cols[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // iter dots, check col/row/box sets
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (!rows[i].add(board[i][j])
                        || !cols[j].add(board[i][j])
                        || !boxes[boxIdx].add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean f = new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        System.out.println(f);
    }
}
