package leetcode.decide;


/**
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积
 * 思路： 全排列 + 二维数组压缩成一维数组
 *
 * @author QiuHongLong
 */
public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        decide(matrix, 0);
        return maxArea;
    }


    private void decide(int[][] matrix, int index) {
        if (index == matrix[0].length) {
            compute(matrix);
            return;
        }
        for (int i = index; i < matrix[0].length; i++) {
            swap(matrix, index, i);
            decide(matrix, index + 1);
            swap(matrix, index, i);
        }
    }


    private void swap(int[][] matrix, int a, int b) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][a];
            matrix[i][a] = matrix[i][b];
            matrix[i][b] = temp;
        }
    }


    private void compute(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] compress = compress(matrix, i);
            doCompute(compress);
        }
    }


    private int[] compress(int[][] matrix, int level) {
        int[] compress = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            boolean hasMeetNotZero = false;
            for (int j = 0; j <= level; j++) {
                int current = matrix[j][i];
                if (current != 0) hasMeetNotZero = true;
                if (current == 0 && hasMeetNotZero) {
                    sum = 0;
                    break;
                }
                sum += current;
            }
            compress[i] = sum;
        }
        return compress;
    }

    private int maxArea = Integer.MIN_VALUE;

    private void doCompute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curHigh = arr[i];
            int left = -1;
            int right = arr.length;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < curHigh) {
                    left = j;
                    break;
                }
            }
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < curHigh) {
                    right = j;
                    break;
                }
            }
            int curArea = (right - left - 1) * curHigh;
            maxArea = Math.max(curArea, maxArea);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestSubmatrixWithRearrangements().largestSubmatrix(new int[][]{{1, 1, 0}, {1, 0, 1}}));
    }

}
