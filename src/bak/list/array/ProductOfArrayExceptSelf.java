package bak.list.array;


/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @author QiuHongLong
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        // 如何 O(N) 时间复杂度 ? 空间换时间

        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        leftToRight[0] = 1;
        for (int i = 1; i < leftToRight.length; i++) {
            leftToRight[i] = leftToRight[i - 1] * nums[i - 1];
        }
        rightToLeft[rightToLeft.length - 1] = 1;
        for (int i = rightToLeft.length - 2; i >= 0; i--) {
            rightToLeft[i] = rightToLeft[i + 1] * nums[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = leftToRight[i] * rightToLeft[i];
        }

        return result;
    }

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
    }

}
