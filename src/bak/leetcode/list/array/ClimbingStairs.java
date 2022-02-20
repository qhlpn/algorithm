package bak.leetcode.list.array;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author QiuHongLong
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public int climbStairsV2(int n) {

        // DP ： 到 n 层楼有多少种方法
        // 状态：现在到了第几层楼
        // 选择：一步 or 两步 （到达现在的状态）


        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }



    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(34));
    }

}
