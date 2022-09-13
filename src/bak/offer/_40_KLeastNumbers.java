package bak.offer;

import java.util.ArrayList;

// ����n���������ҳ�������С��K������
// �������� 4,5,1,6,2,7,3,8 ��8�����֣�
// ����С��4�������� 1,2,3,4��

public class _40_KLeastNumbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length || k < 1) return new ArrayList<>();
        bubbleSort(input);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            al.add(input[i]);
        }
        return al;
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) swap(array, j, j + 1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList al = GetLeastNumbers_Solution(array, 3);
        System.out.println();
    }
}
