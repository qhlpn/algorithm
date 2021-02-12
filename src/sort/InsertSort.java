package sort;

/**
 * @author QiuHongLong
 */
public class InsertSort {

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        // stable
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println();

    }

    public static void main(String[] args) {
        new InsertSort().sort(new int[]{1, 3, 5, 2, 4, 6});
    }

}
