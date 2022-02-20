package bak.leetcode.list.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 按大小顺序列出所有排列情况，给定 n 和 k，返回第 k 个排列
 * @author QiuHongLong
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        permutation(arr, 0, list);

        list.sort(Comparator.comparingInt(l -> l));

        return String.valueOf(list.get(k - 1));

    }


    private void permutation(int[] arr, int index, List<Integer> list) {

        if (index == arr.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int val : arr) {
                sb.append(val);
            }
            list.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutation(arr, index + 1, list);
            swap(arr, index, i);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3, 3);
    }

}
