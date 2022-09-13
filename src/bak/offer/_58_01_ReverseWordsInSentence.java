package bak.offer;

// 翻转单词顺序
// I am a student. --> student. a am I


// 思路  整个先翻转一次
//      再每个单词翻转
//      翻转两次
public class _58_01_ReverseWordsInSentence {

    public String ReverseSentence(String str) {
        if (str == "" || str == null) {
            return "";
        }
        char[] chars = str.toCharArray();
        strSwap(chars, 0, chars.length - 1);
        int start = 0;
        int end = 0;
        while (start < chars.length) {
            end++;
            if (end == chars.length || chars[end] == ' ') {
                strSwap(chars, start, end - 1);
                ++end;
                start = end;
            }
        }
        return String.valueOf(chars);
    }

    public void strSwap(char[] chars, int first, int end) {
        int length = end - first + 1;
        for (int i = first; i < first + length / 2; i++) {
            char help = chars[i];
            chars[i] = chars[end];
            chars[end] = help;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}
