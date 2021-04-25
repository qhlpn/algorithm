package leetcode.dynamic;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * @author QiuHongLong
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) return true;
        if (wordDict.size() == 0) return true;

        // 状态：s 的前 j 位
        // 选择：i in [0,j] 跳到 j 。
        // 转移：判断 dp[i] && s.substring(i,j)
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = false;
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("car");
        dict.add("ca");
        dict.add("rs");
        new WordBreak().wordBreak("cars", dict);
    }

}
