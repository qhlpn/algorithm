package bak.list.linked;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * @author QiuHongLong
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        int val1;
        int val2;
        int sum;
        int remaind;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 + carry;
            carry = sum / 10;
            remaind = sum % 10;
            ListNode one = new ListNode(remaind);
            temp.next = one;
            temp = one;

        }

        return head.next;

    }


}
