package bak.leetcode.list.linked;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author QiuHongLong
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode init = new ListNode(-1, head);
        ListNode left = init;
        ListNode right = head;

        while (--n >= 0) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return init.next;
    }


}


// x 1 2 3 4 5
//   2 --> 4
//   x 3
// 3 null