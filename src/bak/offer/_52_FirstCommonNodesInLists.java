package bak.offer;

// 输入两个链表，找出它们的第一个公共结点。

public class _52_FirstCommonNodesInLists {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int length1 = GetLength(pHead1);
        int length2 = GetLength(pHead2);
        int distance = Math.abs(length1 - length2);
        ListNode pLong = pHead1;
        ListNode pShort = pHead2;
        if (length1 < length2) {
            pLong = pHead2;
            pShort = pHead1;
        }
        for (int i = 0; i < distance; i++)
            pLong = pLong.next;
        while (pLong != pShort && pLong != null) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return pLong;
    }

    public int GetLength(ListNode node) {
        int i = 0;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        return i;
    }
}
