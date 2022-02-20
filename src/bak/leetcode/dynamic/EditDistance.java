package bak.leetcode.dynamic;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：插入、删除、替换
 *
 * @author QiuHongLong
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    // eg: dp[i][j] -> horse  ros
                    // p[i - 1][j - 1] : 先 hors  -> ro 再 ro[e->s]    替换
                    // p[i][j - 1]     : 先 horse -> ro 再 ro[nvl->s]  新增
                    // p[i - 1][j]     : 先 hors -> ros 再 ros[e->nvl] 删除
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}

