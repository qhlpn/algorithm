package bak.leetcode.decide;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 */
public class LetterCombineOfPhoneNumber {

    private static HashMap<String, List<String>> dict = new HashMap() {{
        put("2", Arrays.asList("a", "b", "c"));
        put("3", Arrays.asList("d", "e", "f"));
        put("4", Arrays.asList("g", "h", "i"));
        put("5", Arrays.asList("j", "k", "l"));
        put("6", Arrays.asList("m", "n", "o"));
        put("7", Arrays.asList("p", "q", "r", "s"));
        put("8", Arrays.asList("t", "u", "v"));
        put("9", Arrays.asList("w", "x", "y", "z"));
    }};


    private static List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        doLetterCombinations(digits, 0, new StringBuilder());
        return result;
    }

    private void doLetterCombinations(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            if (sb.length() != 0) result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        List<String> opts = dict.get(String.valueOf(c));
        for (String opt : opts) {
            sb.append(opt);
            doLetterCombinations(digits, index + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }


    public static void main(String[] args) {
        List<String> res = new LetterCombineOfPhoneNumber().letterCombinations("");
        System.out.println();
    }
}
