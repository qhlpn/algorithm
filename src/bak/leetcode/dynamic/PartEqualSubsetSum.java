package bak.leetcode.dynamic;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author QiuHongLong
 */
public class PartEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return doCheckContain(nums, target);

    }

    private boolean doCheckContain(int[] nums, int target) {

        boolean[][] dp = new boolean[target + 1][nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = false;
        }
        dp[0][0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean dontAdd = false;
                if (j >= 2) {
                    dontAdd = dp[i][j - 1];
                }
                boolean doAdd = false;
                if (i >= nums[j - 1]) {
                    doAdd = dp[i - nums[j - 1]][j - 1];
                }
                dp[i][j] = dontAdd || doAdd;

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        new PartEqualSubsetSum().canPartition(new int[]{1, 5, 3, 5});
    }

}
