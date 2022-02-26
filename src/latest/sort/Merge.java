package latest.sort;

/**
 * 后序遍历 + 合并
 */
public class Merge {

    private void sort(int[] arr) {

        doSort(arr, 0, arr.length - 1);
    }

    private void doSort(int[] arr, int l, int r) {

        if (l >= r) return;
        int m = l + (r - l) / 2;
        doSort(arr, l, m);
        doSort(arr, m + 1, r);
        merge(arr, l, r);

    }

    private void merge(int[] arr, int l, int r) {
        if (l >= r) return;
        int[] temp = new int[r - l + 1];
        int i = 0;
        int lr = l + (r - l) / 2;
        int rl = lr + 1;
        while (l <= lr && rl <= r) {
            if (arr[l] < arr[rl]) {
                temp[i++] = arr[l++];
            } else if (arr[l] > arr[rl]) {
                temp[i++] = arr[rl++];
            } else {
                temp[i++] = arr[l++];
                temp[i++] = arr[rl++];
            }
        }
        if (l <= lr) {
            while (l <= lr) {
                temp[i++] = arr[l++];
            }
        }
        if (rl <= r) {
            while (rl <= r) {
                temp[i++] = arr[rl++];
            }
        }
        for (int i1 = temp.length - 1; i1 >= 0; i1--) {
            arr[r--] = temp[i1];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 5, 4, 6, 7, 8};
        new Merge().sort(arr);
        System.out.println();
    }

}
