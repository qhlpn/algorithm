package bak.offer;

// ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��

public class _23_EntryNodeInListLoop {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /////////////////////////////////////////////////
    //             ˼·��������
    // 1���ж����޻�
    //    ͷ���˫ָ��(һ��������)���������л�
    // 2�����㻷�Ľڵ��� K
    //    �ڻ�����Ȧ����һȦ�ڵ���
    // 3������ڽڵ�
    //    ͷ���һָ�룬�� K+1 ���ڵ�һָ��,һ��һ���������������
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
