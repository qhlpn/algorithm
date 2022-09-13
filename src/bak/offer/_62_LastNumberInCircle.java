package bak.offer;


// 0, 1, �� , n-1 �� n �������ų�һ��ȦȦ��
// ������ 0 ��ʼÿ�δ�Բ����ɾ���� m �����֡�
// ������ȦȦ��ʣ�µ����һ�����֡�

import java.util.LinkedList;
import java.util.ListIterator;

public class _62_LastNumberInCircle {

    // ˼·һ���û�������ʵ��
    //        LinkList  ��������ListIterator ���ڵ�����������ɾ
    //        �߽�
    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        ListIterator it = list.listIterator();
        int step = 1;
        while (list.size() != 1) {
            if (!it.hasNext()) {
                it = list.listIterator();
            }
            Integer i = (Integer) it.next();
            if (step == m) {
                it.remove();
                step = 1;
            } else {
                step++;
            }
        }
        return list.get(0);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int LastRemaining_SolutionI(int n, int m) {
        if (n < 1 || m < 1) return -1;
        Node head = new Node(0);
        Node pre = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            pre.next = node;
            pre = node;
            if (i == n - 1)
                pre.next = head;
        }
        while (n != 1) {
            for (int i = 0; i < m - 2; i++)
                head = head.next;
            head.next = head.next.next;
            System.gc();
            head = head.next;
            n--;
        }
        return head.data;
    }

    public static int LastRemaining_SolutionII(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();  // --> �ؼ�
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }


    public static void main(String[] args) {
        System.out.println(LastRemaining_SolutionI(7, 3));
        System.out.println(LastRemaining_SolutionII(7, 3));
    }

}
