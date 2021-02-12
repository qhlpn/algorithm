package sort;

/**
 * @author QiuHongLong
 */
public class SelectSort {

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        // unstable
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println();

    }

    public static void main(String[] args) {
        new SelectSort().sort(new int[]{1, 3, 5, 2, 4, 6});
    }

}
