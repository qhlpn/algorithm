package latest.dfs;

import java.util.*;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 */
public class InvalidParentheses {

    private static final Map<Character, Integer> DIC = new HashMap<Character, Integer>() {
        {
            put('(', 1);
            put(')', -1);
            put('#', 0);
        }
    };


    private Set<String> visited = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        doRemove(cs, 0);
        Iterator<String> it = visited.iterator();
        int maxLen = Integer.MIN_VALUE;
        while (it.hasNext()) {
            maxLen = Math.max(it.next().length(), maxLen);
        }
        it = visited.iterator();
        while (it.hasNext()) {
            if (it.next().length() < maxLen) it.remove();
        }
        List<String> result = new LinkedList<>(visited);
        if (result.isEmpty()) result.add("");
        return result;
    }

    private void doRemove(char[] cs, int idx) {
        if (idx == cs.length) return;
        if (isValid(cs))
            visited.add(buildRes(cs));

        doRemove(cs, idx + 1);
        char tmp = cs[idx];
        cs[idx] = '#';
        doRemove(cs, idx + 1);
        cs[idx] = tmp;
    }


    private boolean isValid(char[] cs) {
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            sum += DIC.get(cs[i]);
            if (sum < 0) return false;
        }
        return sum == 0;
    }

    private String buildRes(char[] cs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (DIC.get(cs[i]) != 0) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new InvalidParentheses().removeInvalidParentheses("()())()");
    }
}
