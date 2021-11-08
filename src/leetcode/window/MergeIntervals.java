package leetcode.window;


import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author QiuHongLong
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> l[0] - r[0]);
        int[][] result = new int[intervals.length][2];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if (right >= intervals[j][0]) {
                    right = Math.max(right, intervals[j][1]);
                    i = j;
                } else {
                    break;
                }
            }
            result[count][0] = left;
            result[count][1] = right;
            count++;
        }
        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}});
    }

}
