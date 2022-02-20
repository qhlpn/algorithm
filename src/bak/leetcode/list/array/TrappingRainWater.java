package bak.leetcode.list.array;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * @author QiuHongLong
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int[][] record = new int[height.length][2];

        for (int i = 1; i < height.length - 1; i++) {
            // left
            int leftMax = height[i];
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }

            // right
            int rightMax = height[i];
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }

            record[i][0] = leftMax - height[i];
            record[i][1] = rightMax - height[i];

        }

        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            total += Math.min(record[i][0], record[i][1]);
        }

        return total;
    }

    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5});
    }

}
