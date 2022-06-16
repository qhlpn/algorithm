package latest.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class PerfectSquares {

    private class dfs {

        private int result = Integer.MAX_VALUE;
        public int numSquares(int n) {
            doNumSquares(n, 0);
            return result;
        }

        private void doNumSquares(int rest, Integer level) {
            int top = (int) Math.sqrt(rest);
            int[] chooses = new int[top];
            for (int i = 0; i < top; i++) {
                chooses[i] = i + 1;
            }
            for (int i = chooses.length - 1; i >= 0; i--) {
                int choose = chooses[i];
                rest -= choose * choose;
                if (rest == 0) {
                    result = Math.min(result, level + 1);
                    return;
                }
                doNumSquares(rest, level + 1);
                rest += choose * choose;
            }
        }
    }



    // 动态规划
    // 递归 + 备忘录 版本
    // 定义函数「ret = fun(x)」 + 存在「重叠子问题」

    private Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        return doNumSquares(n);
    }

    private int doNumSquares(int rest) {
        if (memo.containsKey(rest))
            return memo.get(rest);
        int top = (int) Math.sqrt(rest);
        int[] chooses = new int[top];
        for (int i = 0; i < top; i++) {
            chooses[i] = i + 1;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = chooses.length - 1; i >= 0; i--) {
            int choose = chooses[i];
            rest -= choose * choose;
            if (rest == 0) return 1;
            ret = Math.min(doNumSquares(rest) + 1, ret);
            rest += choose * choose;
        }
        memo.put(rest, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(5));
    }


}
