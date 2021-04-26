package leetcode.window;

import java.util.TreeMap;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * @author QiuHongLong
 */
public class SlideWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 红黑树（平衡搜索二叉树）排序
        TreeMap<Integer, Integer> sortMap = new TreeMap<>((l, r) -> r - l);
        for (int i = 0; i < k; i++) {
            if (sortMap.containsKey(nums[i])) {
                sortMap.put(nums[i], sortMap.get(nums[i]) + 1);
            } else {
                sortMap.put(nums[i], 1);
            }
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = sortMap.firstKey();
        for (int i = 1; i < result.length; i++) {
            int rem = nums[i - 1];
            int add = nums[k + i - 1];
            if (sortMap.containsKey(add)) {
                sortMap.put(add, sortMap.get(add) + 1);
            } else {
                sortMap.put(add, 1);
            }
            if (sortMap.get(rem) > 1) {
                sortMap.put(rem, sortMap.get(rem) - 1);
            } else {
                sortMap.remove(rem);
            }
            result[i] = sortMap.firstKey();
        }
        return result;

    }


    public static void main(String[] args) {
        new SlideWindowMax().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
