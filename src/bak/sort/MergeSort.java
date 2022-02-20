package bak.sort;

/**
 * postorder + merge
 * @author QiuHongLong
 */
public class MergeSort {

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);

        System.out.println();
    }


    private void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + (end - begin) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private void merge(int[] arr, int begin, int mid, int end) {

        int[] help = new int[end - begin + 1];
        int helpIdx = 0;
        int leftIdx = begin;
        int rightIdx = mid + 1;

        while (leftIdx <= mid && rightIdx <= end) {
            if (arr[leftIdx] < arr[rightIdx]) {
                help[helpIdx++] = arr[leftIdx++];
            } else {
                help[helpIdx++] = arr[rightIdx++];
            }
        }
        while (rightIdx <= end) {
            help[helpIdx++] = arr[rightIdx++];
        }
        while (leftIdx <= mid) {
            help[helpIdx++] = arr[leftIdx++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[begin + i] = help[i];
        }

    }


    public static void main(String[] args) {
        new MergeSort().sort(new int[]{1, 8, 5, 2, 4, 6});
    }

}
