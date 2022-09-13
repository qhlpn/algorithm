package bak.offer;

// 单调递增数组中
// 找出数值与下标相等的元素
public class _53_03_IntegerIdenticalToIndex {

    public static int IntegerIdenticalToIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
