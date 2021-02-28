package leetcode.list.linked;

/**
 * 给定一个链表，判断链表中是否有环。
 * @author QiuHongLong
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        boolean isCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        return isCycle;

    }


}
