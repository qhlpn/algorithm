package latest.dfs;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class PerfectSquares {

    private int result = Integer.MAX_VALUE;

    public int numSquares(int n) {

        int top = (int) Math.sqrt(n);
        int[] chooses = new int[top];
        for (int i = 0; i < top; i++) {
            chooses[i] = i + 1;
        }
        doNumSquares(chooses, n, 0);
        return result;
    }

    private void doNumSquares(int[] chooses, int rest, Integer level) {
        for (int i = chooses.length - 1; i >= 0; i--) {
            int choose = chooses[i];
            rest -= choose * choose;
            if (rest == 0) {
                result = Math.min(result, level + 1);
                return;
            }
            int nextTop = (int) Math.sqrt(rest);
            int[] nextChooses = new int[nextTop];
            for (int j = 0; j < nextTop; j++) {
                nextChooses[j] = j + 1;
            }
            doNumSquares(nextChooses, rest, level + 1);
            rest += choose * choose;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(5));
    }

}
