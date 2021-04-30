package leetcode.list.linked;

import java.util.*;

/**
 * 判断是否为回文链表
 *
 * @author QiuHongLong
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        List<Integer> array = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            array.add(node.val);
            node = node.next;
        }
        for (int left = 0, right = array.size() - 1; left <= right; ++left, --right) {
            if (!array.get(left).equals(array.get(right))) return false;
        }
        return true;

        // O(1) 空间？ 先翻转后半部链表

    }

}
