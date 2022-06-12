package latest.sort;

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
        int target = arr[right];

        // lIdx | target | rIdx
        int lIdx = left - 1;
        int rIdx = right;
        int fIdx = left;

        while (fIdx < rIdx) {
            if (arr[fIdx] > target) {
                swap(arr, fIdx, --rIdx);
            } else if (arr[fIdx] < target) {
                swap(arr, ++lIdx, fIdx++);
            } else {
                fIdx++;
            }
        }
        swap(arr, rIdx++, right);
        return new int[]{lIdx, rIdx};
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 1, 1, 1, 1, 1, 1};
        new Quick().sort(arr);
        System.out.println();
    }

}
