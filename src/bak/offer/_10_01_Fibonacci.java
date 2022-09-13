package bak.offer;

// 要求输入一个整数n，请你输出斐波那契数列的第n项
// 0 1 1 2 3 5 8 13 21 - - -
public class _10_01_Fibonacci {

    ////////////////////////////////////////////////////////////////////
    // 1、递归版
    // 重复遍历，量级是一棵树 时间 O(N ^ 2)  -- 不可用公式
    // 时间复杂度的理解：对数据遍历的总次数（以量级来表示）
    public static int fibonacciRecur(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciUnRecur(n - 1) + fibonacciUnRecur(n - 2);
    }

    ////////////////////////////////////////////////////////////////////
    // 2、非递归版
    // 从下往上解决问题，动态规划思想
    // 效率优 每个数只遍历一次 时间O(N)
    public static int fibonacciUnRecur(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 0;
        int in = 1;
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = pre + in;
            pre = in;
            in = pos;
        }
        return pos;
    }

    ////////////////////////////////////////////////////////////////////
    // 3、把求斐波那契数列转换成求矩阵[1 1]的 N-1 次方
    //                           [1 0]
    // 乘方 N 次可用递归 (N/2)^2，时间复杂度变成 O(logn)
    // f(n) = f(n-i) + f(n-j) 均可转换成矩阵的乘方
}
