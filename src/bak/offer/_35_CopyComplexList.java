package bak.offer;

// 输入一个复杂链表（每个节点中有节点值，以及两个指针，
// 一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空

public class _35_CopyComplexList {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    ///////////////////////////////////////////////////////////
    //  1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
    //  2、遍历链表，A1->random = A->random->next;
    //  3、将链表拆分成原链表和复制后的链表
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);
    }

    public static void CloneNodes(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode node = new RandomListNode(pHead.label);
            node.next = pHead.next;
            pHead.next = node;
            pHead = node.next;
        }
    }

    public static void ConnectSiblingNodes(RandomListNode pHead) {
        while (pHead != null) {
            if (pHead.random == null) {
                pHead.next.random = null;
            } else {
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }
    }

    public static RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode pre = pHead;
        RandomListNode cloneHead = pHead.next;
        RandomListNode clone = pHead.next;
        while (clone.next != null) {
            pre.next = clone.next;
            pre = clone.next;
            clone.next = pre.next;
            clone = pre.next;
        }
        pre.next = null;
        return cloneHead;
    }

    ///////////////////////////////////////////////////////////
    // 用哈希表存<N、N'>对应关系

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n5;
        n3.random = null;
        n4.random = n2;
        n5.random = null;
        RandomListNode clone = Clone(n1);
        System.out.println();
    }
}