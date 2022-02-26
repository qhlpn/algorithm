package latest.sort;

/**
 * 三色域 partition + 前序遍历
 */
public class Quick {

    public void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int[] res = partition(arr, left, right);
        doSort(arr, left, res[0]);
        doSort(arr, res[1], right);
    }

    private int[] partition(int[] arr, int left, int right) {
        int lastElem = arr[right];
        int under = left - 1;
        int high = right - 1;
        while (left <= high) {
            if (arr[left] < lastElem) {
                swap(arr, ++under, left++);
            } else if (arr[left] == lastElem) {
                left++;
            } else {
                swap(arr, left, high--);
            }
        }
        swap(arr, ++high, right);
        return new int[]{under, high + 1};

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 5, 4, 6, 7, 8};
        new Quick().sort(arr);
        System.out.println();
    }

}
