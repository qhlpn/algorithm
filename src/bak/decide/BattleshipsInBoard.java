package bak.decide;

import java.util.*;

/**
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * 1. 给你一个有效的甲板，仅由战舰或者空位组成。
 * 2. 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 3. 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 */
public class BattleshipsInBoard {


    private int res = 0;
    private final Set<Pot> set = new HashSet<>();

    public int countBattleships(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, new Pot(i, j), Arrays.asList(Direct.LEFT, Direct.RIGHT, Direct.UP, Direct.DWONT), true);
            }
        }

        return res;
    }


    private void dfs(char[][] board, Pot pot, List<Direct> opt, boolean isFirst) {
        if (set.contains(pot)) return;
        set.add(pot);
        if (opt.size() == 0)  return;
        if (board[pot.row][pot.col] == 'X') {
            if (isFirst)
                res++;
            for (Direct direct : opt) {
                if (direct == Direct.LEFT) {
                    Pot left = new Pot(pot.row, pot.col - 1);
                    if (left.col >= 0 && board[left.row][left.col] == 'X')
                        dfs(board, left, Collections.singletonList(Direct.LEFT), false);
                } else if (direct == Direct.RIGHT) {
                    Pot right = new Pot(pot.row, pot.col + 1);
                    if (right.col < board[0].length && board[right.row][right.col] == 'X')
                        dfs(board, right, Collections.singletonList(Direct.RIGHT), false);
                } else if (direct == Direct.UP) {
                    Pot up = new Pot(pot.row - 1, pot.col);
                    if (up.row >= 0 && board[up.row][up.col] == 'X')
                        dfs(board, up, Collections.singletonList(Direct.UP), false);
                } else if (direct == Direct.DWONT) {
                    Pot down = new Pot(pot.row + 1, pot.col);
                    if (down.row < board.length && board[down.row][down.col] == 'X')
                        dfs(board, down, Collections.singletonList(Direct.DWONT), false);
                }
            }
        }

    }


    private static enum Direct {
        LEFT, RIGHT, UP, DWONT,
    }


    private static class Pot {
        private int row;
        private int col;

        public Pot(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pot) {
                return ((Pot) o).row == this.row && ((Pot) o).col == this.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return row + col;
        }

    }

    public static void main(String[] args) {
        new BattleshipsInBoard().countBattleships(
                new char[][]{
                        {'X', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', '.', '.', 'X'}
                });
    }


}
