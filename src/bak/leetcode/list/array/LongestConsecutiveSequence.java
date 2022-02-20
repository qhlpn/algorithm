package bak.leetcode.list.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 O(N)
 * @author QiuHongLong
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        // dict
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        // O(N)
        for (int num : nums) {
            if (set.remove(num)) {
                int curLen = 1;
                int curNum = num;
                while (set.remove(curNum - 1)) {
                    curNum--;
                }
                curLen += num - curNum;
                curNum = num;
                while (set.remove(curNum + 1)) {
                    curNum++;
                }
                curLen += curNum - num;
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }

}
