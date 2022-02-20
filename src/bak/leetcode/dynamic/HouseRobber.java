package bak.leetcode.dynamic;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author QiuHongLong
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // dp[day][0/1] 今天第i天，是否处于能够进入房屋的状态
        // 动作：进入/不进入， +nums[i] 指的是今天的操作
        // 转移：处于能够进入房屋的状态时（可以执行有两种动作：进入/不进入）
        //       处于不能够进入房屋的状态时（只能执行一种动作：不进入）
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1]) + nums[i]);
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

}
