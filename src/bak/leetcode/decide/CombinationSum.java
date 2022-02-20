package bak.leetcode.decide;

import java.util.*;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        doCombinationSum(candidates, 0, new LinkedList<Integer>(), 0, target, result);
        return result;
    }

    private void doCombinationSum(int[] candidates, int index, List<Integer> state, int currentSum, int target, List<List<Integer>> result) {
        if (currentSum > target) return;
        if (currentSum == target) {
            List<Integer> copy = new LinkedList<>(state);
            result.add(copy);
            return;
        }
        if (index == candidates.length) return;

        int leftSum = target - currentSum;
        int number = candidates[index];
        int count = leftSum / number;
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j < i; j++) {
                state.add(number);
            }
            doCombinationSum(candidates, index + 1, state, currentSum + i * number, target, result);
            for (int j = 0; j < i; j++) {
                state.remove(state.size() - 1);
            }
        }

    }

}
