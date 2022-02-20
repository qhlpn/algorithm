package bak.leetcode.string;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1
 * @author QiuHongLong
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean isSame = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new ImplementStrStr().strStr("a", "a");
    }
}
