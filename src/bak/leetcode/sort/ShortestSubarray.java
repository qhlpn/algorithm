package bak.leetcode.sort;

import java.util.Arrays;

/**
 * @author QiuHongLong
 */
public class ShortestSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                left = i;
                break;
            }
        }
        int right = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                right = i;
                break;
            }
        }
        return left == -1 ? 0 : right - left + 1;

    }
}
