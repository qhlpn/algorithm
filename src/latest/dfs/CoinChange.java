package latest.dfs;

import java.util.*;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {


    private class dfs {

        private final List<Integer> res = new LinkedList<>();

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            doChoice(coins, amount, 0);
            Optional<Integer> min = res.stream().min(Comparator.comparingInt(l -> l));
            return min.orElse(-1);
        }

        private void doChoice(int[] coins, int amount, int level) {
            if (amount == 0) {
                res.add(level);
                return;
            }
            if (amount < 0) return;
            for (int i = 0; i < coins.length; i++) {
                int choose = coins[i];
                int rest = amount - choose;
                doChoice(coins, rest, level + 1);
            }
        }
    }

    // 动态规划
    // 递归 + 备忘录 版本
    // 定义函数「ret = fun(x)」 + 存在「重叠子问题」
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        return doChoice(coins, amount);

    }

    private final Map<Integer, Integer> memo = new HashMap<>();
    private int doChoice(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.containsKey(amount)) return memo.get(amount);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int next = doChoice(coins, amount - coins[i]);
            if (next >= 0 && next < Integer.MAX_VALUE) {
                ret = Math.min(ret, next);
            }
        }
        ret = ret == Integer.MAX_VALUE ? -1 : ret + 1;
        memo.put(amount, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

}
