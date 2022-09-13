package bak.offer;

// 求1+2+3+...+n，要求不能使用
// 乘除法、for、while、if、else、switch、case等关键字
// 及 条件判断语句（A?B:C）

public class _64_Accumulate {

    // 思路：
    // 不能用乘法 --> 则用循环累加 -->
    // 但不能循环 --> 则用递归解决 -->
    // 递归要有出口，但不能用判断语句 --> 使用短路语法

    public int Sum_Solution(int n) {
        boolean t =
                (n != 0) && ((n += Sum_Solution(n - 1)) != 0);
        return n;
    }
}
