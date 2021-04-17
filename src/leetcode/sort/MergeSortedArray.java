package leetcode.sort;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * @author QiuHongLong
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < temp.length; i++) {
            if (idx1 == m || idx2 == n) break;
            if (nums1[idx1] < nums2[idx2]) {
                temp[i] = nums1[idx1++];
            } else {
                temp[i] = nums2[idx2++];
            }
        }

        if (idx1 == m) {
            for (int i = idx1 + idx2; i < temp.length; i++) {
                temp[i] = nums2[idx2++];
            }
        } else if (idx2 == n) {
            for (int i = idx1 + idx2; i < temp.length; i++) {
                temp[i] = nums1[idx1++];
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{1}, 1, new int[]{}, 0);
    }

}
