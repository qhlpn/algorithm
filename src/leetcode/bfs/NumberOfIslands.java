package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author QiuHongLong
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int rows = grid.length + 2;
        int cols = grid[0].length + 2;
        char[][] newGrid = new char[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i + 1][j + 1] = grid[i][j];
            }
        }
        int cnt = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (newGrid[i][j] == '1') {
                    cnt++;
                    Queue<Integer[]> queue = new LinkedList<>();
                    Integer[] ints = new Integer[]{i, j};
                    queue.add(ints);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i1 = 0; i1 < size; i1++) {
                            Integer[] pop = queue.poll();
                            int row = pop[0];
                            int col = pop[1];
                            if (newGrid[row][col - 1] == '1') {
                                queue.add(new Integer[]{row, col - 1});
                                newGrid[row][col - 1] = '2';
                            }
                            if (newGrid[row][col + 1] == '1') {
                                queue.add(new Integer[]{row, col + 1});
                                newGrid[row][col + 1] = '2';
                            }
                            if (newGrid[row - 1][col] == '1') {
                                queue.add(new Integer[]{row - 1, col});
                                newGrid[row - 1][col] = '2';
                            }
                            if (newGrid[row + 1][col] == '1') {
                                queue.add(new Integer[]{row + 1, col});
                                newGrid[row + 1][col] = '2';
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }));
    }
}
