package bak.leetcode.decide;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        doGenerateParenthesis(new StringBuilder(), Collections.singletonList("("), n, 0, 0, res);
        return res;

    }

    private void doGenerateParenthesis(StringBuilder state, List<String> opt, int total, int left, int right, List<String> res) {
        if (left == total && right == total) {
            res.add(state.toString());
            return;
        }
        for (int i = 0; i < opt.size(); i++) {
            String s = opt.get(i);
            state.append(s);
            if ("(".equals(s)) {
                left++;
            } else if (")".equals(s)) {
                right++;
            }
            List<String> nextOpt = new ArrayList<>();
            if (left < total && left == right) {
                nextOpt = Collections.singletonList("(");
            } else if (left < total && left > right) {
                nextOpt = Arrays.asList("(", ")");
            } else if (left == total && left > right) {
                nextOpt = Collections.singletonList(")");
            }

            doGenerateParenthesis(state, nextOpt, total, left, right, res);
            state.delete(state.length() - 1, state.length());
            if ("(".equals(s)) {
                left--;
            } else if (")".equals(s)) {
                right--;
            }
        }
    }


}
