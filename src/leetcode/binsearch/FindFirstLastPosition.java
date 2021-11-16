package leetcode.binsearch;

/**
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *  如果数组中不存在目标值 target，返回[-1, -1]。
 */
public class FindFirstLastPosition {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];

        int resLeft = -1;
        int lIdx = 0;
        int rIdx = nums.length - 1;
        while (lIdx <= rIdx) {
            int mIdx = lIdx + (rIdx - lIdx) / 2;
            if (nums[mIdx] == target) {
                resLeft = mIdx;
                rIdx = mIdx - 1;
            } else if (nums[mIdx] > target) {
                rIdx = mIdx - 1;
            } else {
                lIdx = mIdx + 1;
            }
        }
        res[0] = resLeft;


        int resRight = -1;
        lIdx = 0;
        rIdx = nums.length - 1;
        while (lIdx <= rIdx) {
            int mIdx = lIdx + (rIdx - lIdx) / 2;
            if (nums[mIdx] == target) {
                resRight = mIdx;
                lIdx = mIdx + 1;
            } else if (nums[mIdx] < target) {
                lIdx = mIdx + 1;
            } else {
                rIdx = mIdx - 1;
            }
        }
        res[1] = resRight;

        return res;

    }

    public static void main(String[] args) {
        new FindFirstLastPosition().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
