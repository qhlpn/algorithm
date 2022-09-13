package bak.offer;


// 给定单向链表的头指针和节点指针，
// 定义一个函数在O(1)时间内删除该节点。

// 注意：提供的是节点指针
// 而不是说删除第几个节点，否则无法O(1)
// 区别：头指针(链表指针) 、头节点
// OJ上的 头指针 是 头结点，故需要自己建个 zo 指向整个链表 (_18_02_)


public class _18_01_DeleteNodeInList {


    private class Node {
        private Object data;
        private Node next;
    }

    //////////////////////////////////////////////////////////
    // 解法1、遍历到指定节点的前一个节点 时间 O(N)
    // 同 _02_Queue_Stack_List_Array --> Code_04_LinkedList

    //////////////////////////////////////////////////////////
    // 解法2、根据提供的条件：节点指针
    // delete --> next --> nnext
    // delete -->nnext (next的内容给了delete)
    public static void DeleteNode(Node phead, Node delete) {
        if (phead != null || delete != null) return;
        // 删除的节点不是尾节点
        if (delete.next != null) {
            Node next = delete.next;
            delete.data = next.data;
            delete.next = next.next;
            System.gc();  // next游离状态
        } else {
            // 链表只有1个节点，删除的节点既是尾节点也是头节点
            if (phead.next == delete) {
                phead.next = null;
                System.gc();
            } else { // 链表有多个节点，删除的节点位于尾节点，
                // 此时只能遍历了
                while (phead.next != delete) {
                    phead = phead.next;
                }
                phead.next = null;
                System.gc();
            }
        }
    }
}
