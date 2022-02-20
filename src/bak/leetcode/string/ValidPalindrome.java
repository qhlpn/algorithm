package bak.leetcode.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 * @author QiuHongLong
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isAlphabetOrDigital(s.charAt(i))) {
                char c = Character.toUpperCase(s.charAt(i));
                sb.append(c);

            }
        }
        s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    private boolean isAlphabetOrDigital(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        new ValidPalindrome().isPalindrome("race a car");
    }



}
