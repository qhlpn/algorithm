package bak.offer;

// 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)
// 每段绳子的长度记为 k[0],k[1],...,k[m].
// 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
// 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.

public class _14_CuttingRope {

    //////////////////////////////////////////////////////////
    // 递归版 f(n) = max(f(i)*f(n-i))
    // 如何切分是要看底层的情况，从下往上切分，而这里从上往下切分，错误
    // 如何沉到底部是关键
    //    private static boolean cut = false;
    //    public static int error(int length) {
    //        if (length == 1 || length == 0) return 1;
    //        int max = length;
    //        if (cut && length == 2) return 2;
    //        if (cut && length == 3) return 3;
    //        if (!cut && (length == 2 || length == 3)) max = 0;
    //        cut = true;
    //        int flag = 0;
    //        // 切分的条件是从下往上，这里变成从上往下，错误
    //        for (int i = 1; i < length; i++) {
    //            if (max <= i * (length - i)) {
    //                max = i * (length - i);
    //                flag = i;
    //            }
    //        }
    //        return error(flag) * error(length - flag);
    //    }

    // 暴力递归(枚举)版 f(n) = max(f(i)*f(n-i))
    private static boolean cut = false;

    public static int maxProductAfterCuttingI(int length) {
        if (!cut) {
            if (length == 0) return 0;
            if (length == 1) return 0;
            if (length == 2) return 1;
            if (length == 3) return 2;
        }
        cut = true;
        if (length == 1) return 1;
        if (length == 2) return 2;
        if (length == 3) return 3;
        int[] record = new int[length / 2 + 1];
        // 暴力枚举沉底
        for (int i = 1; i < length / 2 + 1; i++) {
            record[i] = maxProductAfterCuttingI(i) * maxProductAfterCuttingI(length - i);
        }
        int max = 0;
        for (int i = 1; i < length / 2 + 1; i++) {
            if (max < record[i]) max = record[i];
        }
        return max;
    }

    //////////////////////////////////////////////////////////
    // 暴力递归改成动态规划
    // 套路：1、根据变量的个数、取值范围建表
    //        --> 这里变量只有 length 一个(是指函数的传参变量？切点i不算)、取值范围是[0~length]
    //            故建一维的表，即数组，大小 new int[length + 1]
    //      2、往表中填入basecase的情况
    //        --> 这里basecase是 maxArray[1] = 1; maxArray[2] = 2; maxArray[3] = 3;
    //      3、根据 basecase 和 题目的条件 搭积木，把表的数据填满，返回另一侧端点的数据
    //        --> 题目条件：max(f(n)*f(n-1))
    //            返回的另一侧端点数据是 maxArray[length]
    // 时间 O(N2) 空间 O(N)
    public static int maxProductAfterCuttingII(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] maxArray = new int[length + 1];
        maxArray[1] = 1;
        maxArray[2] = 2;
        maxArray[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (max < maxArray[j] * maxArray[i - j])
                    max = maxArray[j] * maxArray[i - j];
            }
            maxArray[i] = max;
        }
        return maxArray[length];
    }

    //////////////////////////////////////////////////////////
    // 贪心算法
    // 绳子长度 >= 5时，每次切掉 3;直到 < 5
    // 时间 O(N) 空间 O(1)
    public static int maxProductAfterCuttingIII(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        if (length == 4)
            return 4;
        int max = 1;
        while (length >= 5) {
            max = max * 3;
            length = length - 3;
        }
        return (max = max * length);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            System.out.print(i + " ");
            if (maxProductAfterCuttingII(i) != maxProductAfterCuttingI(i) ||
                    maxProductAfterCuttingII(i) != maxProductAfterCuttingIII(i)) {
                System.out.println("Fucking Fucked!");
            }
        }
        System.out.println();
        System.out.println("Nice!");
    }
}
