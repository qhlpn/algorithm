package bak.offer;


import java.util.Stack;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class _46_TranslateNumbersToStrings {

    public static void translateNumbersToStrings(int number) {
        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(number % 10);
            number = number / 10;
        } while (number != 0);
        int size = stack.size();
        int[] num = new int[size];
        for (int i = 0; i < size; i++)
            num[i] = stack.pop();
        StringBuffer sb = new StringBuffer();
        Recur(num, 0, sb);
    }

    public static void Recur(int[] num, int index, StringBuffer sb) {
        if (index == num.length) {
            System.out.println(sb.toString());
            return;
        }
        sb.append((char)(97 + num[index]));
        Recur(num, index + 1, sb);
        sb.delete(sb.length() - 1, sb.length());
        if (num.length - 1 - index >= 1
                && num[index] * 10 + num[index + 1] >= 10
                && num[index] * 10 + num[index + 1] <= 25) {
            sb.append((char)( 97 + num[index] * 10 + num[index + 1]));
            Recur(num, index + 2, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public static void main(String[] args) {
        translateNumbersToStrings(12258);
    }
}
