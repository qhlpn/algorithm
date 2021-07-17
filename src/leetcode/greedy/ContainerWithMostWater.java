package leetcode.greedy;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * @author QiuHongLong
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                maxArea = Math.max(maxArea, Math.min(left, right) * (j - i));
            }
        }
        return maxArea;

    }


    public int maxArea2(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            // 向内移动短板，水槽的面积才有可能增大，才有继续比下去的需要
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;


    }

}
