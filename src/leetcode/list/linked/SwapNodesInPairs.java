package leetcode.list.linked;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * @author QiuHongLong
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode init = new ListNode(-1, head);

        ListNode left = init;
        ListNode node = head;
        ListNode right = head.next;

        while (right != null) {

            left.next = right;
            node.next = right.next;
            right.next = node;

            left = right;
            right = node.next;
            if (right != null) {
                left = left.next;
                node = node.next;
                right = right.next;
            }
        }

        return init.next;

    }

}


// t -> 1 -> 2 -> t
// left node right
// left right node
//      left  node right