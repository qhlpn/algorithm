package bak.offer;


// 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法
// （先后次序不同算不同的结果）。
public class _10_02_FrogJumpFloorI {

    ////////////////////////////////////////////////////////////////////
    // 设 n 级台阶跳法方式有 f(n)
    // f(n) = 第 1 次跳1级台阶 + 第 1 次跳2级台阶
    //         剩 n-1 级台阶      剩 n-2 级台阶
    // 递归 --> f(n) = f(n-1) + f(n-2)
    // 其实就是斐波那契数列
    public static int jumpFloorRecur(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return jumpFloorRecur(target - 1) + jumpFloorRecur(target - 2);
    }

    public static int jumpFloorUnRecur(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int pre = 1;
        int in = 2;
        int pos = 0;
        for (int i = 3; i <= target; i++) {
            pos = pre + in;
            pre = in;
            in = pos;
        }
        return pos;
    }
}
