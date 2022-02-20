package bak.leetcode.list.linked;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * @author QiuHongLong
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode node = head;
        int cnt = 1;
        while (node.next != null) {
            node = node.next;
            cnt++;
        }

        node.next = head;
        int step = cnt - k % cnt;

        while (--step >= 0) {
            node = node.next;
        }

        ListNode ret = node.next;
        node.next = null;

        return ret;

    }
}


// 1 2 3

// 1

//