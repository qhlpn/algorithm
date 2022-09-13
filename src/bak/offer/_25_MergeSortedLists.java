package bak.offer;

// 输入两个单调递增的链表，输出两个链表合成后的链表，
// 当然我们需要合成后的链表满足单调不减规则。

public class _25_MergeSortedLists {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode MergeList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode bef = head;
        ListNode now;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                now = list2;
                list2 = list2.next;
                bef.next = now;
                bef = now;
            } else {
                now = list1;
                list1 = list1.next;
                bef.next = now;
                bef = now;
            }
        }
        if (list1 == null) {
            bef.next = list2;
        }
        if (list2 == null) {
            bef.next = list1;
        }
        return head.next;
    }




    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode w1 = new ListNode(4);
        ListNode w2 = new ListNode(5);
        ListNode w3 = new ListNode(6);
        h1.next = h2;
        h2.next = h3;
        w1.next = w2;
        w2.next = w3;
        ListNode node = MergeList(h1, w1);
        System.out.println(node);

    }
}
