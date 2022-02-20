package bak.leetcode.list.linked;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 * @author QiuHongLong
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode nodeSlider = head;

        while (node != null) {
            if (node.val == nodeSlider.val) {
                node = node.next;
                nodeSlider.next = node;
            } else {
                nodeSlider.next = node;
                node = node.next;
                nodeSlider = nodeSlider.next;
            }
        }

        return head;

    }

}
