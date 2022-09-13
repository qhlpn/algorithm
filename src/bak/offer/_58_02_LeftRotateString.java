package bak.offer;

// ����ת�ַ���
// abcdfg --����2λ������ѭ���ƶ�2λ��-> cdfgab


// ˼·�� ���������ָ��Է�ת
//       ������ܵķ�ת
//       һ����ת����
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
