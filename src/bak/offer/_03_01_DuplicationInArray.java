package bak.offer;

// 找出数组中任意一个重复的数字（可能存在）
// 在一个长度为 n 的数组里的所有数字都在 0 ~ n-1 范围

import java.util.HashSet;

public class _03_01_DuplicationInArray {

    ////////////////////////////////////////////////////////////////
    // 1、排序后扫描整个数组  时间 O(nlogn) + O(n) ~ O(nlogn)
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, (int) (l + Math.random() * (r - l + 1)), r);
            int[] p = partiton(arr, l, r);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[1], r);
        }
    }

    public static int[] partiton(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less, more + 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean duplicate_01(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        quickSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                resp[0] = arr[i];
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////
    // 2、扫描数组，利用哈希表  时间 O(n) 空间 O(n)
    public static boolean duplicate_02(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        HashSet<Integer> con = new HashSet();
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = con.add(arr[i]);
            if (!flag) {
                resp[0] = arr[i];
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////
    // 3、最佳解 (根据条件: 数组长度 N,值范围 0 ~ N-1)
    // 思路：从头遍历数组，判断数组值与下标值是否相等。
    //      是 --> 继续遍历，不是 --> 判断数组值与下标是数组值的数组值是否相等
    //                             是 --> 找到重复数，不是 --> 交换，遍历的数组值归位(数组值等于下标值)
    // 时间 O(n) 空间 O(1)
    public static boolean duplicate_03(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    resp[0] = arr[i];
                    return true;
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 1, 3, 2, 1};
        int[] resp = new int[1];
        boolean flag = duplicate_03(arr, resp);
        if (flag) {
            System.out.println("重复的数字是 " + resp[0]);
        } else {
            System.out.println("不存在重复的数字");
        }
    }
}
