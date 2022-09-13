package bak.offer;

// ��һ������������У������ظ��Ľ�㣬
// ��ɾ�����������ظ��Ľ�㣬
// �ظ��Ľ�㲻��������������ͷָ�롣(ͷ���)
// ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5

public class _18_02_DeleteDuplicatedNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //////////////////////////////////////////////////////////
    //   ����������������������������������
    //  |                 |
    // pre  in in in in next   ���ظ���ʱ��in ���������ߣ� pre ������
    //                                   ��� pre ָ�� next
    //         pre in
    //     pre in
    // pre in                  ���ظ���ʱ��in pre ����������
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        // OJ�ϵ�ͷָ����ͷ��㣬����Ҫ�Լ����� zo ָ����������
        ListNode zo = new ListNode(-1);
        zo.next = pHead;
        ListNode pre = zo;
        ListNode in = zo.next;
        boolean flag = false;
        while (in != null) {
            flag = false;
            while (in.next != null && in.val == in.next.val) {
                ListNode temp = in;
                in = in.next;
                temp.next = null;
                flag = true;
            }
            if (flag) {
                pre.next = in.next;
                in = in.next;
            } else {
                pre = pre.next;
                in = in.next;
            }
        }
        System.gc();
        return zo.next;
    }

    public static void traverse(ListNode pHead) {
        if (pHead == null) {
            System.out.print("����Ϊ��");
        } else {
            System.out.print("��");
            while (pHead != null) {
                System.out.print("->[" + pHead.val + "]");
                pHead = pHead.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(1);
        ListNode h4 = new ListNode(1);
        ListNode h5 = new ListNode(1);
        ListNode h6 = new ListNode(1);
        ListNode h7 = new ListNode(2);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        traverse(h1);
        ListNode head = deleteDuplication(h1);
        traverse(head);

    }
}
