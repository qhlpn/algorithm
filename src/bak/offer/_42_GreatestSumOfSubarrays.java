package bak.offer;


// 输入一个整型数组，数组里有正数也有负数。
// 数组中的一个或连续多个整数组成一个子数组。
// 求所有子数组和的最大值。
// 要求时间复杂度为 O(n)
public class _42_GreatestSumOfSubarrays {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i]) sum = array[i];
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3};
        System.out.println(FindGreatestSumOfSubArray(array));

    }
}
