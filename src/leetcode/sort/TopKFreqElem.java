package leetcode.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author QiuHongLong
 */
public class TopKFreqElem {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((l, r) -> map.get(r) - map.get(l));
        queue.addAll(map.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        new TopKFreqElem().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

}
