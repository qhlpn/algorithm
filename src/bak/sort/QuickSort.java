package bak.sort;

/**
 * partition + preorder
 * @author QiuHongLong
 */
public class QuickSort {


    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.println();

    }


    private void quickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int[] res = partition(arr, l, r);
        // 闭区间
        quickSort(arr, l, res[0]);
        quickSort(arr, res[1], r);
    }


    private int[] partition(int[] arr, int l, int r) {

        // random quickSort
        swap(arr, l + (int) (Math.random() * (r - l)), r);

        int less = l;
        int more = r - 1;
        int target = arr[r];

        while (l <= more) {
            if (arr[l] == target) {
                l++;
            } else if (arr[l] < target) {
                // need swap
                swap(arr, less++, l++);
            } else if (arr[l] > target) {
                // unstable
                swap(arr, more--, l);
            }
        }
        swap(arr, ++more, r);
        // -- left -- |target| -- right --
        return new int[]{less - 1, more + 1};
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{1, 8, 5, 2, 4, 6});
    }

}
