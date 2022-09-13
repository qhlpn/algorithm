package bak.offer;

// ����һ������ͻ������ڵĴ�С��
// �ҳ����л�����������ֵ�����ֵ��

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _59_01_MaxInSlidingWindow {

    // ˼·һ������ ʱ�� O(size*N)
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

    //˼·������������ --�����ɣ�--  ����
    //       ����ʹ��˫����У���������index
    //       ��ͷ��ŵ�ǰ���ֵ��index
    //       ÿ�δӶ�β���룬ǰ�����бȼ����С�ģ����滻��
    //       �ж϶�ͷ��index�Ƿ��ڴ�����
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
