package bak.leetcode.dynamic;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @author QiuHongLong
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        // [金额数M][持有前N种硬币]
        int[][] dp = new int[amount + 1][coins.length + 1];

        for (int i = 0; i < dp.length; i++) dp[i][0] = -1;
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = -1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                int coin = coins[j - 1];
                if (i < coin) {
                    dp[i][j] = dp[i][j - 1];
                } else if (i == coin) {
                    dp[i][j] = 1;
                } else if (i > coin) {
                    if (dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - coin][j] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - coin][j] + 1);
                    }

                }

            }
        }

        return dp[amount][coins.length];

    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }


}
