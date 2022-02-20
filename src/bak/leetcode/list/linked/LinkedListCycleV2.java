package bak.leetcode.list.linked;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author QiuHongLong
 */
public class LinkedListCycleV2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 判断有无环
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return null;
        }

        // 计算环的大小
        int cnt = 1;
        while (slow.next != fast) {
            slow = slow.next;
            cnt++;
        }

        // 环入口（0 cnt / 1 cnt+1 前行）
        // cnt + x = L
        ListNode left = head;
        ListNode right = head;
        while (cnt-- > 0) {
            right = right.next;
        }

        while (left != right) {
            left = left.next;
            right = right.next;
        }

        return left;

    }


}
