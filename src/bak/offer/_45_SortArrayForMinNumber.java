package bak.offer;

import java.util.ArrayList;


// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
// 打印能拼接出的所有数字中最小的一个。
// 例如输入数组 {3，32，321}，
// 则打印出这三个数字能排成的最小数字为 321323。
public class _45_SortArrayForMinNumber {

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        ArrayList<String> al = new ArrayList<>();
        Recur(numbers, 0, al);
        long min = Long.valueOf(al.get(0));
        for (int i = 0; i < al.size(); i++) {
            if (min > Long.valueOf(al.get(i)))
                min = Long.valueOf(al.get(i));
        }
        return Long.toString(min);
    }


    public static void Recur(int[] numbers, int start, ArrayList<String> al) {
        if (start == numbers.length) {
            String str = new String();
            for (int i = 0; i < numbers.length; i++)
                str += numbers[i];
            al.add(str);
        }
        for (int i = start; i < numbers.length; i++) {
            swap(numbers, start, i);
            Recur(numbers, start + 1, al);
            swap(numbers, start, i);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3334, 3, 3333332};
        System.out.println(PrintMinNumber(array));
    }
}
