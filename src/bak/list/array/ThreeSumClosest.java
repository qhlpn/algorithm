package bak.list.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * @author QiuHongLong
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minDist = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum < target) {
                    left++;
                } else if (curSum > target) {
                    right--;
                } else {
                    return curSum;
                }
                int temp = minDist;
                minDist = Math.min(minDist, Math.abs(curSum - target));
                closest = minDist < temp ? curSum : closest;
            }
        }

        return closest;

    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 2));
    }

}
