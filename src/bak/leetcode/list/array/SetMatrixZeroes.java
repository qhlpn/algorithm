package bak.leetcode.list.array;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 * @author QiuHongLong
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < cols.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                for (int j = 0; j < rows.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }


}
