package leetcode.dynamic;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * @author QiuHongLong
 */
public class PerfectSquares {

    public int numSquares(int n) {

        // 状态：到了正整数 n
        // 动作：加 / 不加
        // 转移：在 lastNum ，当前 n 执不执行动作来满足条件
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int maxSqrt = (int) Math.floor(Math.sqrt(i));
            int minSum = Integer.MAX_VALUE;
            for (int j = 0; j <= maxSqrt; j++) {
                int lastNum = i - (int) Math.pow(j, 2);
                if (lastNum >= 0 &&
                        (lastNum == 0 || dp[lastNum] != 0)){
                    minSum = Math.min(minSum, dp[lastNum]);
                }
            }
            dp[i] = minSum == Integer.MAX_VALUE ? 0 : minSum + 1;
        }
        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        new PerfectSquares().numSquares(12);
    }

}
