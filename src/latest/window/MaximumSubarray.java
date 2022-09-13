package latest.window;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author QiuHongLong
 */
public class MaximumSubarray {

    // curSum：表示以 nums[i] 结尾 的连续子数组的最大和

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        int curSum = 0;
        while (index < nums.length) {
            if (curSum < 0) {
                curSum = 0;
            } else {
                curSum += nums[index++];
                maxSum = Math.max(curSum, maxSum);
            }
        }
        return maxSum;

    }


    public static void main(String[] args) {
        new MaximumSubarray().maxSubArray(new int[]{5, 4, -1, 7, 8});
    }

}
