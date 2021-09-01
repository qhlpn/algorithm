package sort;

/**
 * 上冒初始化堆 + 交换 + 下沉恢复堆
 * <p>
 * PriorityQueue
 *
 * @author QiuHongLong
 */
public class HeapSort {

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        buildHeap(arr);

        int size = arr.length - 1;
        swap(arr, 0, size--);
        while (size > 0) {
            heapify(arr, size);
            swap(arr, 0, size--);
        }

        System.out.println();

    }

    private void buildHeap(int[] arr) {
        // like insertSort
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            // big top ( parent > left && parent > right )
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                // up to be parent
                index = (index - 1) / 2;
            }
        }
    }


    private void heapify(int[] arr, int size) {
        int index = 0;
        int left = 2 * index + 1;
        while (left <= size) {
            int max = (left + 1 <= size && arr[left + 1] > arr[left]) ? left + 1 : left;
            // unstable
            if (arr[max] > arr[index]) {
                swap(arr, max, index);
                index = max;
                left = 2 * index + 1;
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
        new HeapSort().sort(new int[]{1, 3, 5, 2, 4, 6});
    }

}
