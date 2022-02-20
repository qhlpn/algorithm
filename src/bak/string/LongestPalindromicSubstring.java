package bak.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author QiuHongLong
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {

        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (isPalindrome(s, i, i + j)) {
                    int newLength = j + 1;
                    if (maxLength < newLength) {
                        maxLength = newLength;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }


    private boolean isPalindrome(String s, int start, int end) {

        int length = end - start + 1;
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(s.charAt(start + i))
                    != Character.toUpperCase(s.charAt(end - i))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("aba");
    }

}
