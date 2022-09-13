package bak.offer;

// 左旋转字符串
// abcdfg --左旋2位（向左循环移动2位）-> cdfgab


// 思路： 左右两部分各自翻转
//       最后再总的翻转
//       一共翻转三次
public class _58_02_LeftRotateString {

    public static String LeftRotateString(String str, int n) {
        if (str == null || n < 0) return null;
        if (str.length() == 0) return "";
        if (n > str.length()) n = n - str.length();
        char[] chars = str.toCharArray();
        Reverse(chars, 0, n - 1);
        Reverse(chars, n, chars.length - 1);
        Reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    public static void Reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = LeftRotateString("abcd", 5);
        System.out.println(str);
    }
}
