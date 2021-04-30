package leetcode.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * @author QiuHongLong
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (doCheck(s.substring(i, j + 1))) {
                    result++;
                }
            }
        }
        return result;
    }


    private boolean doCheck(String s) {
        for (int left = 0, right = s.length() - 1;
             left <= right; ++left, --right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromicSubstrings().countSubstrings("aaa");
    }

}
