package bak.leetcode.list.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * @author QiuHongLong
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                // 可破坏原数组
                nums[slow + 1] = nums[fast];
                slow++;
                fast++;
            }
        }

        return slow + 1;
    }

}