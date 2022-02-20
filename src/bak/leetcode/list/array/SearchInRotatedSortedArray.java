package bak.leetcode.list.array;

/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转
 * 例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2]
 * 在数组中搜索 target，返回它的索引
 * @author QiuHongLong
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 右段
            if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 左段
            if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[mid] == nums[left]) {
                left++;
            }
            
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{3, 1}, 1));
    }

}