package bak.offer;

// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

public class _21_ReorderArray {

    //////////////////////////////////////////////////////
    // 遍历判断，拿出数字，整体向前挪动一位，数字放在最后一格
    // 时间 O(N^2)
    public static void reOrderArrayI(int[] array) {
        if (array == null || array.length == 0) return;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[index] % 2 == 0) {
                int temp = array[index];
                int help = index;
                while (help < array.length - 1) {
                    array[help] = array[help + 1];
                    help++;
                }
                array[array.length - 1] = temp;
            } else index++;
        }
    }

    //////////////////////////////////////////////////////
    // 双指针，一个前往后，一个后往前
    // 时间 O(N) 无法实现相对位置不变
    // 解耦 出解决一系列同类型问题的通用方法
    // C：函数指针  Java：反射？
    public static void reOrderArrayII(int[] arr) {
        int f = 0;
        int l = arr.length - 1;
        int temp;
        while (f < l) {
            if (arr[f] % 2 == 1) {
                f++;
            } else {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l--] = temp;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 1, 1, 7};
        reOrderArrayII(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
