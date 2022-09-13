package bak.offer;

// ����һ����������������е�����k����㡣

public class _22_KthNodeFromEnd {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /////////////////////////////////////////////////////
    // �ȱ���һ��ͳ�Ƹ������ٶ�λ
    // ע�����³���� 1��head == null
    //              2��k == 0
    //              3��k > length
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        int length = 1;
        ListNode help = head;
        while (help.next != null) {
            length++;
            help = help.next;
        }
        if (k > length) return null;
        int tick = 1;
        help = head;
        while (tick != length - k + 1) {
            tick++;
            help = help.next;
        }
        return help;
    }


}
