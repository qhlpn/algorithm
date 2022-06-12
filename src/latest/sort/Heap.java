package latest.sort;

public class Heap {

    public void sort(int[] arr) {
        bottomToUp(arr);
        for (int i = 1; i < arr.length; i++) {
            swap(arr, 0, arr.length - i);
            upToBottom(arr, arr.length - i - 1);
        }
    }

    private void bottomToUp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i;
            while (true) {
                int parent = (tmp - 1) / 2;
                if (arr[tmp] > arr[parent]) {
                    swap(arr, tmp, parent);
                    tmp = parent;
                } else {
                    break;
                }
            }
        }
    }

    private void upToBottom(int[] arr, int lastIdx) {
        int fIdx = 0;
        while (true) {
            int lIdx = 2 * fIdx + 1;
            int rIdx = 2 * fIdx + 2;
            if (rIdx <= lastIdx && arr[rIdx] > arr[lIdx] && arr[fIdx] < arr[rIdx]) {
                swap(arr, fIdx, rIdx);
                fIdx = rIdx;
            } else if (lIdx <= lastIdx && arr[fIdx] < arr[lIdx]) {
                swap(arr, fIdx, lIdx);
                fIdx = lIdx;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6, 9, 7};
        new Heap().sort(arr);
        System.out.println();
    }

}
