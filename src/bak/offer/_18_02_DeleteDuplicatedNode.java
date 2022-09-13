package bak.offer;

// 在一个排序的链表中，存在重复的结点，
// 请删除该链表中重复的结点，
// 重复的结点不保留，返回链表头指针。(头结点)
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

public class _18_02_DeleteDuplicatedNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //////////////////////////////////////////////////////////
    //   —————————————————
    //  |                 |
    // pre  in in in in next   有重复点时，in 不断往下走， pre 不动，
    //                                   最后 pre 指向 next
    //         pre in
    //     pre in
    // pre in                  无重复点时，in pre 不断往下走
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        // OJ上的头指针是头结点，故需要自己建个 zo 指向整个链表
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
            System.out.print("链表为空");
        } else {
            System.out.print("●");
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
