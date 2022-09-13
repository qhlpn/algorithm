package bak.offer;

import java.util.ArrayList;

// 输入一个递增排序的数组和一个数字S，
// 在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，输出两个数的乘积最小的。

public class _57_01_TwoNumbersWithSum {

    // 思路一： 固定一个数，匹配其它数  时间O(N2)

    // 思路二： 前后两个指针，相遇操作  时间O(N)
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> al = new ArrayList<>();
        if (array == null || array.length == 0) return al;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int help = array[start] + array[end];
            if (help > sum) {
                end--;
            } else if (help < sum) {
                start++;
            } else {
                al.add(array[start]);
                al.add(array[end]);
                return al;
            }
        }
        return al;
    }
}
