package latest.sort;

public class Merge {

    public void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        doSort(arr, left, mid);
        doSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        int lfIdx = left;
        int rfIdx = mid + 1;
        int[] tmp = new int[right - left + 1];
        int tIdx = 0;
        while (lfIdx <= mid && rfIdx <= right) {
            if (arr[lfIdx] <= arr[rfIdx]) {
                tmp[tIdx++] = arr[lfIdx++];
            } else {
                tmp[tIdx++] = arr[rfIdx++];
            }
        }
        while (lfIdx <= mid) {
            tmp[tIdx++] = arr[lfIdx++];
        }
        while (rfIdx <= right) {
            tmp[tIdx++] = arr[rfIdx++];
        }
        System.arraycopy(tmp, 0, arr, left, right - left + 1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 1, 1, 1, 1};
        new Merge().sort(arr);
        System.out.println();
    }
}
