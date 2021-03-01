package leetcode.list.linked;

import java.util.ArrayList;

/**
 * 给定一个单链表：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author QiuHongLong
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> array = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            array.add(node);
            node = node.next;
        }

        ListNode init = new ListNode(-1);
        node = init;
        for (int i = 0; i < array.size() / 2; i++) {
            node.next = array.get(i);
            node = node.next;
            node.next = array.get(array.size() - 1 - i);
            node = node.next;
        }

        if (array.size() % 2 == 0) {
            node.next = null;
        } else {
            node.next = array.get(array.size() / 2);
            node.next.next = null;
        }

    }


    // 空间 O(1)：找到中间节点，断开，把后半截单链表reverse后，合并两个单链表

    public static void main(String[] args) {
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode n0 = new ListNode(1, n1);
        new ReorderList().reorderList(n0);
    }


    // 0 1 2 3 4
    // 0 4 1 2
}

