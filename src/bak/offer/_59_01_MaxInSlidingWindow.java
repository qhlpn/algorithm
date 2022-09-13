package bak.offer;

// 给定一个数组和滑动窗口的大小，
// 找出所有滑动窗口里数值的最大值。

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _59_01_MaxInSlidingWindow {

    // 思路一：暴力 时间 O(size*N)
    public static ArrayList<Integer> maxInWindowsI(int[] num, int size) {
        if (num == null || num.length == 0 || size < 1)
            return new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        int start = 0;
        int end = start + size - 1;
        while (end < num.length) {
            al.add(SearchMax(num, start, end));
            start++;
            end++;
        }
        return al;

    }

    public static int SearchMax(int[] num, int start, int end) {
        int max = num[start];
        for (int i = start; i <= end; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    //思路二：滑动窗口 --（看成）--  队列
    //       这里使用双向队列，存放数组的index
    //       队头存放当前最大值的index
    //       每次从队尾加入，前面若有比加入的小的，则替换掉
    //       判断队头的index是否在窗口里
    public static ArrayList<Integer> maxInWindowsII(int[] num, int size) {
        if (num == null || num.length == 0 || size < 1) {
            return new ArrayList<>();
        }
        ArrayList<Integer> resp = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            if (i - deque.peekFirst() >= size) {
                deque.pollFirst();
            }
            if (i >= size-1) {
                resp.add(num[deque.peekFirst()]);
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> al = maxInWindowsI(arr, 3);
        System.out.println();
    }
}
