package sort;

public class BubbleSort {

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        // stable
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }


    public static void main(String[] args) {
        new BubbleSort().sort(new int[]{1, 3, 5, 2, 4, 6});
    }

}
