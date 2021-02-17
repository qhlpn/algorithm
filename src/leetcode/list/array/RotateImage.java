package leetcode.list.array;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像 原地 顺时针旋转 90 度。
 * @author QiuHongLong
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {

                int temp = matrix[i][j];
                // 直接通过举例来找出之间的关系
                // 左 -> 上
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                // 下 -> 左
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                // 右 -> 下
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                // 上 -> 右
                matrix[j][matrix.length - 1 - i] = temp;
            }

        }

        System.out.println();


    }


    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }


    // 5  1  9  11
    // 2  4  8  10
    // 13 3  6  7
    // 15 14 12 16

    // 上 [0][2]
    // 左 [1][0]
    // 下 [3][1]
    // 右 [2][3]


    // 方法二： 先沿着右上对角线翻转一次，再沿着水平中线翻转一次
}
