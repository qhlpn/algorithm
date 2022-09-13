package bak.offer;

// 一个整型数组里除了两个数字之外，
// 其他的数字都出现了偶数次。
// 请写程序找出这两个只出现一次的数字。

public class _56_01_NumbersAppearOnce {

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for (int i = 0; i < array.length; i++)
            xor ^= array[i];
        int index = FindFirstBitIs1(xor);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (IndexIsBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static int FindFirstBitIs1(int number) {
        int index = 0;
        while ((number & 1) == 0) {
            index++;
            number = number >> 1;
        }
        return index;
    }

    public static boolean IndexIsBit1(int number, int index) {
        number = number >> index;
        return !((number & 1) == 0);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println();
    }
}
