package leetcode.list.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度
 */
public class RemoveDuplicatesFromSortedArrayV2 {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;

        int dupCnt = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                dupCnt++;
                if (dupCnt == 1) {
                    nums[slow + 1] = nums[fast];
                    slow++;
                }
                fast++;
            } else {
                dupCnt = 0;
                nums[slow + 1] = nums[fast];
                slow++;
                fast++;
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArrayV2().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

}