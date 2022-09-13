package bak.offer;

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

import java.util.ArrayList;

public class _29_PrintMatrix {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        ArrayList<Integer> al = new ArrayList();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            PintMatrixInCircle(matrix, start, al);
            start++;
        }
        return al;
    }

    public static void PintMatrixInCircle(int[][] matrix, int start, ArrayList<Integer> al) {
        int endX = matrix[0].length - start - 1;
        int endY = matrix.length - start - 1;
        //
        for (int i = start; i <= endX; i++)
            al.add(matrix[start][i]);
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++)
                al.add(matrix[i][endX]);
        }
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; i--)
                al.add(matrix[endY][i]);
        }
        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i > start; i--)
                al.add(matrix[i][start]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}};
        ArrayList<Integer> al = printMatrix(matrix);
    }
}
