package latest.bfs;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    if (!set.contains(pair)) {
                        number++;
                        queue.add(pair);
                        set.add(pair);
                        while (!queue.isEmpty()) {
                            int cnt = queue.size();
                            for (int k = 0; k < cnt; k++) {
                                Pair<Integer, Integer> poll = queue.poll();
                                int x = poll.getKey();
                                int y = poll.getValue();
                                if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                                    Pair<Integer, Integer> right = new Pair<>(x + 1, y);
                                    if (!set.contains(right)) {
                                        queue.add(right);
                                        set.add(right);
                                    }
                                }
                                if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                    Pair<Integer, Integer> left = new Pair<>(x -1, y);
                                    if (!set.contains(left)) {
                                        queue.add(left);
                                        set.add(left);
                                    }
                                }
                                if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                                    Pair<Integer, Integer> bottom = new Pair<>(x, y + 1);
                                    if (!set.contains(bottom)) {
                                        queue.add(bottom);
                                        set.add(bottom);
                                    }
                                }
                                if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                    Pair<Integer, Integer> top = new Pair<>(x, y - 1);
                                    if (!set.contains(top)) {
                                        queue.add(top);
                                        set.add(top);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }

    public static void main(String[] args) {
        new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        
    }
}
