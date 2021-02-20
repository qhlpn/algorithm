package leetcode.list.linked;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 1 ≤ m ≤ n ≤ 链表长度
 * @author QiuHongLong
 */
public class ReverseLinkedListV2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode node = new ListNode(-1);
        ListNode res = node;
        node.next = head;

        for (int i = 1; i < left; i++) {
            node = node.next;
        }

        ListNode start = node;
        ListNode leftNode = node.next;

        ListNode before = null;
        node = node.next;
        ListNode next;

        for (int i = left; i <= right; i++) {
            next = node.next;
            node.next = before;
            before = node;
            node = next;
        }

        ListNode rightNode = before;
        ListNode end = node;

        start.next = rightNode;
        leftNode.next = end;

        return res.next;
    }


    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        new ReverseLinkedListV2().reverseBetween(n1, 2, 4);

    }

}
