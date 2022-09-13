package bak.offer;

// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

public class _23_EntryNodeInListLoop {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /////////////////////////////////////////////////
    //             思路分三步：
    // 1、判断有无环
    //    头结点双指针(一步与两步)，相遇则有环
    // 2、计算环的节点数 K
    //    在环中绕圈，绕一圈节点数
    // 3、找入口节点
    //    头结点一指针，第 K+1 个节点一指针,一步一步，相遇点是入口
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean hasLoop = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {
            int count = 1;
            slow = slow.next;
            while (slow != fast) {
                slow = slow.next;
                count++;
            }
            ListNode pre = pHead;
            ListNode pos = pHead;
            while (count != 0) {
                pos = pos.next;
                count--;
            }
            while (pre != pos) {
                pre = pre.next;
                pos = pos.next;
            }
            return pos;
        } else return null;
    }


    public static ListNode EntryNodeOfLoopII(ListNode pHead) {

        ListNode slow = pHead;
        ListNode fast = pHead;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return new ListNode(3);
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h3;
        System.out.println(EntryNodeOfLoop(h1).val);

    }
}
