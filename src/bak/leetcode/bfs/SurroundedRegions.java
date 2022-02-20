package bak.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    boolean close = true;
                    Set<String> set = new HashSet<>();
                    set.add(i + "@" + j);
                    Queue<String> queue = new LinkedList<>();
                    queue.add(i + "@" + j);
                    List<String> oList = new LinkedList<>();
                    oList.add(i + "@" + j);
                    while (!queue.isEmpty()) {
                        int count = queue.size();
                        for (int k = 0; k < count; k++) {
                            String pop = queue.poll();
                            String[] split = pop.split("@");
                            int row = Integer.parseInt(split[0]);
                            int col = Integer.parseInt(split[1]);

                            int leftRow = row;
                            int leftCol = col - 1;
                            if (!set.contains(leftRow + "@" + leftCol)) {
                                if (leftCol > -1) {
                                    set.add(leftRow + "@" + leftCol);
                                    if (board[leftRow][leftCol] != 'X') {
                                        queue.add(leftRow + "@" + leftCol);
                                        oList.add(leftRow + "@" + leftCol);
                                    }
                                } else {
                                    close = false;
                                }
                            }
                            
                            int rightRow = row;
                            int rightCol = col + 1;
                            if (!set.contains(rightRow + "@" + rightCol)) {
                                if (rightCol < cols) {
                                    set.add(rightRow + "@" + rightCol);
                                    if (board[rightRow][rightCol] != 'X') {
                                        queue.add(rightRow + "@" + rightCol);
                                        oList.add(rightRow + "@" + rightCol);
                                    }
                                } else {
                                    close = false;
                                }
                            }
                            
                            int upRow = row - 1;
                            int upCol = col;
                            if (!set.contains(upRow + "@" + upCol)) {
                                if (upRow > -1) {
                                    set.add(upRow + "@" + upCol);
                                    if (board[upRow][upCol] != 'X') {
                                        queue.add(upRow + "@" + upCol);
                                        oList.add(upRow + "@" + upCol);
                                    }
                                } else {
                                    close = false;
                                }
                            }
                            
                            int downRow = row + 1;
                            int downCol = col;
                            if (!set.contains(downRow + "@" + downCol)) {
                                if (downRow < rows) {
                                    set.add(downRow + "@" + downCol);
                                    if (board[downRow][downCol] != 'X') {
                                        queue.add(downRow + "@" + downCol);
                                        oList.add(downRow + "@" + downCol);
                                    }
                                } else {
                                    close = false;
                                }
                            }

                        }
                    }
                    if (close) {
                        for (String o : oList) {
                            String[] split = o.split("@");
                            int row = Integer.parseInt(split[0]);
                            int col = Integer.parseInt(split[1]);
                            board[row][col] = 'X';
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }


}
