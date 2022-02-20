package bak.dynamic;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author QiuHongLong
 */
public class Stockjobbing {

    public static int maxProfit(int[] prices) {

        // 遍历一遍数组，计算每次 到当天为止 的最小股票价格和最大利润。
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;

        // 动态规划
        // https://mp.weixin.qq.com/s/lQEj_K1lUY83QtIzqTikGA
        // dp[day][deal][0/1] 今天第i天，至今已进行k次交易，手上是否持着股票
        // 动作：卖出/买入
        // 手上持着股票时：（可以执行有两种动作：卖出/买入） // 有交易限制还需考虑交易次数
        // 手上没有持着股票时：（只可执行一种动作：买入）    // 有交易限制还需考虑交易次数
        // dp[day][deal][1] = Math.max(dp[day - 1][deal - 1][0] - prices[day], dp[day - 1][deal][1])
        // dp[day][deal][0] = Math.max(dp[day - 1][deal][1] + prices[day], dp[day - 1][deal][0])

    }

}
