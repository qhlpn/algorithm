package leetcode.binsearch;

/**
 * 有序数组二分查找
 *
 * @author QiuHongLong
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{1, 3, 4, 6, 7}, 3));
    }


}
