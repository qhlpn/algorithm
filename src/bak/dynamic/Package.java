package bak.dynamic;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，
 * 每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为val[i]，
 * 现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * @author QiuHongLong
 */
public class Package {

    public int maxProfit(int w, int n, int[] wt, int[] val) {

        // 状态：背包可载重量为 w, 有前 n 个物品
        // 动作：装/不装 第 n 个物品
        // n + 1 处理后面 j - 1 索引越界
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i >= wt[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - wt[j - 1]][j - 1] + val[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void main(String[] args) {
        new Package().maxProfit(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
    }


}
