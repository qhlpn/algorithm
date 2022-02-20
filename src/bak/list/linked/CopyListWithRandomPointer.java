package bak.list.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝
 * @author QiuHongLong
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node node = head;

        while (node != null) {
            Node clone = new Node(node.val);
            map.put(node, clone);
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node clone = map.get(node);
            clone.next = map.get(node.next);
            clone.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


}
