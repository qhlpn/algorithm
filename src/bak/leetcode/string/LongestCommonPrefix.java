package bak.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。不存在则返回""。
 *
 * @author QiuHongLong
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (index == strs[0].length()) {
                break;

            }
            int target = strs[0].charAt(index);
            if (index == strs[i].length() || strs[i].charAt(index) != target) {
                break;
            }
            if (i == strs.length - 1) {
                index++;
                i = 0;
            }
        }
        return strs[0].substring(0, index);

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"aa", "aa"}));

        Thread t = new Thread(()-> System.out.println("~~~~~~~~~~~~"));
    }

}
