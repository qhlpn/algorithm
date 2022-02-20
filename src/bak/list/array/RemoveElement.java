package bak.list.array;


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @author QiuHongLong
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                swap(nums, left, right--);
            } else {
                left++;
            }
        }

        return left;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[]{1, 2}, 2);
    }

}
