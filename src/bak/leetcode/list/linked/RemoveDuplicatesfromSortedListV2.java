package bak.leetcode.list.linked;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @author QiuHongLong
 */
public class RemoveDuplicatesfromSortedListV2 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int init;
        for (init = 0; init > Integer.MIN_VALUE; init--) {
            if (init != head.val) {
                break;
            }
        }

        ListNode beforeHead = new ListNode(init, head);

        ListNode left = head;
        ListNode leftSlider = beforeHead;

        ListNode right = head.next;

        boolean inSame = false;
        while (right != null) {
            if (left.val == right.val) {
                right = right.next;
                inSame = true;
            } else {
                if (inSame) {
                    leftSlider.next = right;
                    left = leftSlider.next;
                    right = right.next;
                    inSame = false;
                } else {
                    left = left.next;
                    leftSlider = leftSlider.next;
                    right = right.next;
                }
            }
        }

        if (inSame) {
            leftSlider.next = right;
        }

        return beforeHead.next;
    }

}
