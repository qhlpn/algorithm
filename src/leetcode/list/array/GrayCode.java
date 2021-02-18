package leetcode.list.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 格雷编码：两个连续的数值仅有一个位数的差异
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * @author QiuHongLong
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {

        int[] num = new int[n];
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        set.add(0);
        list.add(0);
        decide(num, 1, 1 << n, set, list);
        return list;

    }

    private boolean decide(int[] arr, int cnt, int total, Set<Integer> set, List<Integer> list) {

        if (cnt == total) {
            return true;
        }

        List<Integer> choices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
            choices.add(binToDec(arr));
            arr[i] = 1 - arr[i];
        }

        for (Integer num : choices) {
            if (set.add(num)) {
                list.add(num);
                if (decide(decToBin(num), cnt + 1, total, set, list)) {
                    return true;
                }
                list.remove(num);
                set.remove(num);
            }
        }

        return false;

    }

    private int binToDec(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] << (arr.length - 1 - i);
        }
        return res;
    }

    private int[] decToBin(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int bits = (int) Math.floor(Math.log(num) / Math.log(2) + 1);
        int[] res = new int[bits];
        for (int i = 0; i < res.length; i++) {
            res[i] = (num & (1 << (res.length - 1 - i))) == 0 ? 0 : 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new GrayCode().grayCode(3);
    }

}


//  00  0
//  10  2
//  11  3
//  01  2