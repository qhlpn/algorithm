package latest.window;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author QiuHongLong
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        int right = 0;
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < s.length()) {
            if (passCheck(s, left, right)) {
                right++;
            } else {
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;

    }

    private boolean passCheck(String s, int left, int right) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        new LongestSubstring().lengthOfLongestSubstring("abcabcd");
    }

}
