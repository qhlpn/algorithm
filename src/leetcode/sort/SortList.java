package leetcode.sort;

import leetcode.list.linked.ListNode;

import java.util.Arrays;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @author QiuHongLong
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        for (int i = 0; i < length; i++) {
            node = head;
            for (int j = 0; j < length - i - 1; j++) {
                ListNode curr = node;
                ListNode next = node.next;
                if (next != null && curr.val > next.val) {
                    int temp = curr.val;
                    curr.val = next.val;
                    next.val = temp;
                }
                node = node.next;
            }
        }

        return head;

    }

    public ListNode sortListv2(ListNode head) {

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int[] vals = new int[length];
        node = head;
        for (int i = 0; i < length; i++) {
            vals[i] = node.val;
            node = node.next;
        }

//        quickSort(vals, 0, vals.length - 1);
        Arrays.sort(vals);

        node = head;
        for (int i = 0; i < length; i++) {
            node.val = vals[i];
            node = node.next;
        }


        return head;

    }

    private void quickSort(int[] array, int start, int end) {
        if (start > end) return;
        int[] result = partition(array, start, end);
        quickSort(array, start, result[0]);
        quickSort(array, result[1], end);
    }

    private int[] partition(int[] array, int start, int end) {
        swap(array, start + (int) (Math.random() * (end - start)), end);
        int left = start;
        int right = end - 1;
        int cursor = start;
        int target = array[end];
        while (cursor <= right) {
            if (array[cursor] > target) {
                swap(array, cursor, right--);
            } else if (array[cursor] < target) {
                swap(array, left++, cursor++);
            } else {
                cursor++;
            }
        }
        swap(array, right + 1, end);
        return new int[]{left - 1, right + 2};
    }


    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public static void main(String[] args) {
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(5, n2);

        new SortList().sortListv2(n1);

    }


}
