package leetcode.list.linked;

/**
 *
 * @author QiuHongLong
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {


        ListNode beforeHead = new ListNode(-1, head);

        ListNode fast = head;
        ListNode fastSlider = beforeHead;

        ListNode slow = head;
        ListNode slowSlider = beforeHead;

        while (slow != null) {
            if (slow.val >= x) {
                break;
            }
            slow = slow.next;
            slowSlider = slowSlider.next;
        }

        if (slowSlider.next == null && slowSlider.val < x) {
            return head;
        }

        boolean afterX = false;
        while (fast != null) {

            if (fast.val == x) {
                afterX = true;
                fast = fast.next;
                fastSlider = fastSlider.next;
                continue;
            }

            if (fast.val < x && afterX) {
                fastSlider.next = fast.next;
                fast.next = slow;
                slowSlider.next = fast;

                fast = fastSlider.next;
                slowSlider = slowSlider.next;
                slow = slowSlider.next;
            } else {
                fast = fast.next;
                fastSlider = fastSlider.next;
            }
        }

        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(2);
//        ListNode n4 = new ListNode(5, n5);
//        ListNode n3 = new ListNode(2, n4);
//        ListNode n2 = new ListNode(3, n3);
//        ListNode n1 = new ListNode(4, n2);
//        ListNode n0 = new ListNode(1, n1);
        new PartitionList().partition(n0, 3);
    }

}
