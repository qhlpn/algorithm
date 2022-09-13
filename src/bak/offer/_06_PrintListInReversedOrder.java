package bak.offer;

// 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList

import java.util.ArrayList;
import java.util.Stack;

public class _06_PrintListInReversedOrder {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    ////////////////////////////////////////////////////////////////////
    // 1、逆序 --> 栈
    // 时间O(n) 空间O(n)
    public static ArrayList<Integer> printListReversinglyUnRecur(ListNode listnode) {
        if (listnode == null) {
            return new ArrayList<Integer>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listnode != null) {
            stack.push(listnode.val);
            listnode = listnode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    ////////////////////////////////////////////////////////////////////
    // 2、逆序 --> 栈 --> 递归
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static ArrayList<Integer> printListReversinglyRecur(ListNode listnode) {
        if (listnode != null) {
            printListReversinglyRecur(listnode.next);
            arrayList.add(listnode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(5);
        ListNode node_2 = new ListNode(81);
        ListNode node_3 = new ListNode(61);
        ListNode node_4 = new ListNode(95);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        ArrayList<Integer> arrayList = printListReversinglyRecur(node_1);
        System.out.print("*");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print("-->" + arrayList.get(i));
        }

    }

}