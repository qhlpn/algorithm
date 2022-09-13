package bak.offer;

// 把n个骰子扔在地上，
// 所有骰子朝上一面的点数之和为S。
// 输入n，打印出S的所有可能的值出现的概率。

public class _60_DicesProbability {


    // 思路：
    // 1、n个骰子总可能数 6^n
    // 2、n个骰子点数和为s的情况为 f(n,s)
    //    f(n,s)=f(n-1.s-1)+f(n-1.s-2)+f(n-1.s-3)+f(n-1.s-4)+f(n-1.s-5)+f(n-1.s-6)

    public static int getSumCountI(int n, int s) {
        if (s < n || s > 6 * n || s == 0 || n == 0) {
            return 0;
        }
        if (n == 1 && s <= 6) {
            return 1;
        }
        return getSumCountI(n - 1, s - 1) + getSumCountI(n - 1, s - 2) +
                getSumCountI(n - 1, s - 3) + getSumCountI(n - 1, s - 4) +
                getSumCountI(n - 1, s - 5) + getSumCountI(n - 1, s - 6);
    }


    public static double probabilityI(int n, int s) {
        return getSumCountI(n, s) / Math.pow(6, n);
    }

    // 动态规划版
    // 1、参数2个 --> 构建2维数组
    // 2、定下最终要求的点  dp[n][s]
    // 3、把基本的边界定义出来  dp[1][1-6]=1
    // 4、开始叠积木
    public static int getSumCountII(int n, int s) {
        if (s < n || s > 6 * n || n == 0 || s == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] matrix = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            matrix[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                int index = j;
                while (--index >= i - 1 && index >= j - 6) {
                    matrix[i][j] += matrix[i - 1][index];
                }
                if (i == n && j == s) {
                    return matrix[i][j];
                }
            }
        }
        return 0;
    }

    public static double probabilityII(int n, int s) {
        return getSumCountII(n, s) / Math.pow(6, n);
    }

    public static void main(String[] args) {
        _60_DicesProbability test = new _60_DicesProbability();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 40; j++) {
                if (test.getSumCountII(i, j) != test.getSumCountI(i, j)) {
                    System.out.println("fuck " + i + " " + j + " " + test.getSumCountII(i, j) + " " + test.getSumCountI(i, j));
                }
            }
        }

//        System.out.println(getSumCountII(2, 12));
    }
}
