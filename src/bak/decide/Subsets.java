package bak.decide;

import java.util.*;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * @author QiuHongLong
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();
    private int maxLevel;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        maxLevel = nums.length - 1;
        this.nums = nums;
        doSubsets(new boolean[]{true, false}, new ArrayList<>(), 0);
        return result;
    }

    private void doSubsets(boolean[] opts, List<Integer> state, int level) {

        if (opts.length == 0)
            result.add(new ArrayList<>(state));

        boolean[] nextOpts;
        if (level == maxLevel) {
            nextOpts = new boolean[]{};
        } else {
            nextOpts = new boolean[]{true, false};
        }

        for (boolean opt : opts) {
            if (opt) state.add(nums[level]);
            doSubsets(nextOpts, state, level + 1);
            if (opt) state.remove(state.size() - 1);
        }

    }

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }


}
