package bak.leetcode.list.array;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 O(log(m+n))
 * @author QiuHongLong
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        // 中位数 TRICK: 屏蔽奇偶差异
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;

        if (nums1.length == 0) {
            return (nums2[left - 1] + nums2[right - 1]) / 2.0;
        }

        if (nums2.length == 0) {
            return (nums1[left - 1] + nums1[right - 1]) / 2.0;
        }

        int leftRes = divTwo(nums1, -1, nums2, -1, left);
        int rightRes = divTwo(nums1, -1, nums2, -1, right);
        return (leftRes + rightRes) / 2.0;

    }

    private int divTwo(int[] a, int aIdx, int[] b, int bIdx, int step) {

        if (aIdx >= a.length - 1) {
            return b[bIdx + step];
        }
        if (bIdx >= b.length - 1) {
            return a[aIdx + step];
        }

        if (step == 1) {
            return Math.min(a[aIdx + 1], b[bIdx + 1]);
        }

        int aVal = (aIdx + step / 2 <= a.length - 1) ? a[aIdx + step / 2] : Integer.MAX_VALUE;
        int bVal = (bIdx + step / 2 <= b.length - 1) ? b[bIdx + step / 2] : Integer.MAX_VALUE;

        if (aVal < bVal) {
            return divTwo(a, aIdx + step / 2, b, bIdx, step - step / 2);
        } else {
            return divTwo(a, aIdx, b, bIdx + step / 2, step - step / 2);
        }


    }


    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{5}, new int[]{1, 2, 3, 4, 6}));
    }

}


// 3 1 1
// 5 2 1
// 4 2 0