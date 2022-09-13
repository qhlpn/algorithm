package bak.offer;


// �������������ͷָ��ͽڵ�ָ�룬
// ����һ��������O(1)ʱ����ɾ���ýڵ㡣

// ע�⣺�ṩ���ǽڵ�ָ��
// ������˵ɾ���ڼ����ڵ㣬�����޷�O(1)
// ����ͷָ��(����ָ��) ��ͷ�ڵ�
// OJ�ϵ� ͷָ�� �� ͷ��㣬����Ҫ�Լ����� zo ָ���������� (_18_02_)


public class _18_01_DeleteNodeInList {


    private class Node {
        private Object data;
        private Node next;
    }

    //////////////////////////////////////////////////////////
    // �ⷨ1��������ָ���ڵ��ǰһ���ڵ� ʱ�� O(N)
    // ͬ _02_Queue_Stack_List_Array --> Code_04_LinkedList

    //////////////////////////////////////////////////////////
    // �ⷨ2�������ṩ���������ڵ�ָ��
    // delete --> next --> nnext
    // delete -->nnext (next�����ݸ���delete)
    public static void DeleteNode(Node phead, Node delete) {
        if (phead != null || delete != null) return;
        // ɾ���Ľڵ㲻��β�ڵ�
        if (delete.next != null) {
            Node next = delete.next;
            delete.data = next.data;
            delete.next = next.next;
            System.gc();  // next����״̬
        } else {
            // ����ֻ��1���ڵ㣬ɾ���Ľڵ����β�ڵ�Ҳ��ͷ�ڵ�
            if (phead.next == delete) {
                phead.next = null;
                System.gc();
            } else { // �����ж���ڵ㣬ɾ���Ľڵ�λ��β�ڵ㣬
                // ��ʱֻ�ܱ�����
                while (phead.next != delete) {
                    phead = phead.next;
                }
                phead.next = null;
                System.gc();
            }
        }
    }
}
