package bak.offer;

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级 …… 也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。

public class _10_03_FrogJumpFloorII {
    ////////////////////////////////////////////////////////////////////
    // 设 n 级台阶跳法方式有 f(n)
    // f(n) = 第 1 次跳1级台阶 + 第 1 次跳2级台阶 + 第 1 次跳3级台阶 + ... + 第 1 次跳n级台阶
    // f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(0)     --- ①
    // f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(0)   --- ②
    // ① - ② --> f(n) = 2f(n-1) = 2^(n-1)
    // 直观理解：
    // 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
    public static int jumpFloorRecur(int target) {
        if (target == 1) return 1;
        return 2 * jumpFloorRecur(target - 1);
    }

    public static int jumpFloorUnRecur(int target) {
        if (target == 1) return 1;
        int pre = 1;
        int pos = 0;
        for (int i = 2; i <= target; i++) {
            pos = 2 * pre;
            pre = pos;
        }
        return pos;
    }

    public static int process(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret += process(n - i);
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; ++i) {
            System.out.println(i);
            if (process(i) != jumpFloorUnRecur(i)) {
                System.out.println(false);
                break;
            }
        }
    }
}
