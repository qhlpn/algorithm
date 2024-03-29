package bak.list.linked;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 *
 * @author QiuHongLong
 */
public class LRUCache {

    /**
     *  数据结构：节点双向（方便删除） + HashMap（方便查询）
     *  1、访问页面，将其从原来位置删除（若已存在），并插入到头部。
     * 	2、页面数大于链表容量时，删除尾部
     * 	3、使用HashMap查询操作
     */
    static class LRUv1<K, V> {

        private Node head;
        private Node tail;
        private HashMap<K, Node> map;
        private int maxSize;
        private class Node {
            Node pre;
            Node next;
            K k;
            V v;
            public Node(K k, V v) {
                this.k = k;
                this.v = v;
            }
        }

        public LRUv1(int maxSize) {
            this.maxSize = maxSize;
            this.map = new HashMap<>(maxSize * 4 / 3);
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.pre = head;
        }

        public V get(K key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node node = map.get(key);
            unlink(node);
            appendHead(node);
            return node.v;
        }

        public void put(K key, V value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                unlink(node);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            appendHead(node);
            if (map.size() > maxSize) {
                Node toRemove = removeTail();
                map.remove(toRemove.k);
            }
        }

        private void unlink(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            node.pre = null;
            node.next = null;
        }

        private void appendHead(Node node) {
            Node next = head.next;
            node.next = next;
            next.pre = node;
            node.pre = head;
            head.next = node;
        }

        private Node removeTail() {
            Node node = tail.pre;
            Node pre = node.pre;
            tail.pre = pre;
            pre.next = tail;
            node.pre = null;
            node.next = null;
            return node;
        }
    }


    static class LRUv2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUv2(int capacity) {
            // accessOrder排序模式：访问为 true 插入为 false
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        // 插入操作 Map 会调用此方法
        // 重写移除最近最少使用的key的时机
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

    }


}
