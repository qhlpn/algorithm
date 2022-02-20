package bak.decide;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 - 中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * @author QiuHongLong
 */
public class TargetSum {


    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        doFindTargetSumWays(nums, 0, 0, new int[]{-1, 1});
        return count;
    }

    private int count = 0;
    private int target = 0;
    private void doFindTargetSumWays(int[] nums, int stateLevel, int stateSum, int[] opts) {
        if (opts.length == 0) {
            if (stateSum == target) {
                count++;
            } else {
                return;
            }
        }
        int[] nextOpts;
        if (stateLevel == nums.length - 1) {
            nextOpts = new int[]{};
        } else {
            nextOpts = new int[]{1, -1};
        }
        for (int nextOpt : opts) {
            stateSum += nextOpt * nums[stateLevel];
            doFindTargetSumWays(nums, stateLevel + 1, stateSum, nextOpts);
            stateSum -= nextOpt * nums[stateLevel];
        }
    }



    public static void main(String[] args) {
        new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }

}
