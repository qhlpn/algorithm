package leetcode.binsearch;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素
 */
public class FindMiniInRotatedSortedArray {

    /**
     * 分情况讨论即可：
     * 4种情况
     * 1. left < mid , mid < right -> 向左收缩: right = mid - 1
     * 2. left < mid , mid > right -> 向右收缩：left = mid + 1
     * 3. left > mid , mid < right -> 向左收缩：right = mid (但是不能-1，可能相等)
     * 4. left > mid , mid > right -> 不可能出现单调递减
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (right == mid || left == mid) break;

            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }


    public static void main(String[] args) {
        new FindMiniInRotatedSortedArray().findMin(new int[]{3, 1, 2});
    }

}
