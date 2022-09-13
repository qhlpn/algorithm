package bak.offer;


// 不修改数组找出数组中任意一个重复的数字（必存在）
// 在一个长度为 n + 1 的数组里的所有数字都在 1 ~ n 范围

public class _03_02_DuplicationInArrayNoEdit {

    ////////////////////////////////////////////////////////////////////
    // 1、 采用辅助数组 (投石描黑法)  _03_01_ 也可采用  时间 O(n) 空间 O(n)
    public static boolean duplicate_01(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            help[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == help[arr[i]]) {
                resp[0] = arr[i];
                return true;
            }
            help[arr[i]] = arr[i];
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////
    // 2、 二分法 + 收集数字出现次数  (根据条件: 数组长度 n+1，数字范围 1~n，必有数子出现2次 )
    //     时间换空间   时间 O(nlogn)  空间 O(1)

    // 注意 该题二分法的范围划分  (不同于经典二分查找法 _04_ --> 3个if 化成3段  < x | x | > x )
    // -->  min ~ mid , mid + 1 ~ max
    // -->  1 ~ 7 , min = 1 , max = 7 , mid = 4
    // -->  划分为  1 ~ 4 , 5 ~ 7

    // 如果划分 min ~ mid , mid ~ max 会出现死循环
    // --> {1,2,2}  max = 2, min = 1, mid = 1
    // --> if (counts(arr, min, mid) > (mid - min + 1))     (num = 1) == 1
    //         max = mid;
    //     else
    //         min = mid;                                    min = mid = 1 (死循环)
    //       ( min = mid + 1;)                               min = 2 (不会死循环)


    public static boolean duplicate_02(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        int min = 1;
        int max = arr.length - 1;
        int mid;
        while (max > min) {
            mid = min + ((max - min) >> 1);
            if (counts(arr, min, mid) > (mid - min + 1))
                max = mid;
            else
                min = mid + 1;
        }
        resp[0] = max;
        return true;
    }

    public static int counts(int[] arr, int min, int max) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 2, 6, 7};
        int[] resp = new int[1];
        boolean flag = duplicate_02(arr, resp);
        if (flag) {
            System.out.println("重复的数字是 " + resp[0]);
        } else {
            System.out.println("输入的数字范围有误");
        }
    }
}
