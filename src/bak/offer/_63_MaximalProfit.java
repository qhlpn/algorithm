package bak.offer;

// 求数组中所有数对的最大差值

public class _63_MaximalProfit {
    // 思路一：暴力 O(N2)

    // 思路二：空间换时间  O(N)
    //        设置两个变量 1、存之前最小的值
    //                   2、最大差值（当前值与之前最小值的差 的最大值）
    public static int MaximalProfit(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            maxDiff = arr[i] - min > maxDiff ? arr[i] - min : maxDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(MaximalProfit(arr));
    }

}
