package leetcode.window;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author QiuHongLong
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum = nums[i];
            maxSum = Math.max(maxSum, curSum);
            for (int j = i + 1; j < nums.length; j++) {
                curSum += nums[j];
                maxSum = Math.max(maxSum, curSum);
                if (curSum < nums[j]) {
                    i = j - 1;
                    break;
                }
            }
        }
        return maxSum;

    }


    public static void main(String[] args) {
        new MaximumSubarray().maxSubArray(new int[]{-1, -2});
    }

}
