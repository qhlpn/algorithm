package bak.list.linked;

/**
 * 反转链表
 * @author QiuHongLong
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode left = null;
        ListNode node = head;
        ListNode right;

        while (node != null) {
            right = node.next;
            node.next = left;
            left = node;
            node = right;
        }

        return left;

    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode n0 = new ListNode(1, n1);
        new ReverseLinkedList().reverseList(n0);
    }

}
