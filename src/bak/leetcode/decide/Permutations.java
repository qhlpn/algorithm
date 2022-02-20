package bak.leetcode.decide;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author QiuHongLong
 */
public class Permutations {

    private final List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> rootOpts = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            rootOpts.add(nums[i]);
        }
        List<Integer> initState = new LinkedList<>();
        doPermute(rootOpts, initState);
        return result;
    }

    private void doPermute(List<Integer> opts, List<Integer> state) {
        if (opts.size() == 0) {
            result.add(new LinkedList<>(state));
            return;
        }
        for (Integer opt : opts) {
            state.add(opt);
            List<Integer> nextOpts = new ArrayList<>(opts);
            nextOpts.remove(opt);
            doPermute(nextOpts, state);
            state.remove(opt);
        }
    }

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3});
    }

}
