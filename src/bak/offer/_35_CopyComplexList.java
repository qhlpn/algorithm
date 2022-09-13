package bak.offer;

// ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬
// һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
// ���ؽ��Ϊ���ƺ��������head��
// ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿ�

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
    //  1������ÿ���ڵ㣬�磺���ƽڵ�A�õ�A1����A1����ڵ�A����
    //  2����������A1->random = A->random->next;
    //  3���������ֳ�ԭ����͸��ƺ������
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
    // �ù�ϣ���<N��N'>��Ӧ��ϵ

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