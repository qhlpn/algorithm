package bak.offer;

// 路径总和最大值
public class _47_MaxValueOfGifts {

    // f(i,j) 表示左上角到达 (i,j) 路径总和最大值
    public static int MaxValueOfGiftsI(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) return matrix[0][0];
        if (i == 0) return matrix[i][j] + MaxValueOfGiftsI(matrix, i, j - 1);
        if (j == 0) return matrix[i][j] + MaxValueOfGiftsI(matrix, i - 1, j);
        int left = MaxValueOfGiftsI(matrix, i, j - 1);
        int up = MaxValueOfGiftsI(matrix, i - 1, j);
        return matrix[i][j] + Math.max(left, up);
    }

    // f(i,j) 表示 (i,j) 到达右下角路径总和最大值
    public static int MaxValueOfGiftsII(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];
        if (i == matrix.length - 1) return matrix[i][j] + MaxValueOfGiftsII(matrix, i, j + 1);
        if (j == matrix[0].length - 1) return matrix[i][j] + MaxValueOfGiftsII(matrix, i + 1, j);
        int right = MaxValueOfGiftsII(matrix, i, j + 1);
        int down = MaxValueOfGiftsII(matrix, i + 1, j);
        return matrix[i][j] + Math.max(right, down);
    }

    // I 改成 动态规划 III
    public static int MaxValueOfGiftsI_III(int[][] matrix, int i, int j) {
        int[][] help = new int[matrix.length][matrix[0].length];
        help[0][0] = matrix[0][0];
        for (int x = 1; x < matrix[0].length; x++)
            help[0][x] = help[0][x - 1] + matrix[0][x];
        for (int x = 1; x < matrix.length; x++)
            help[x][0] = help[x - 1][0] + matrix[x][0];
        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[0].length; y++)
                help[x][y] = Math.max(help[x][y - 1], help[x - 1][y]) + matrix[x][y];
        }
        return help[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(MaxValueOfGiftsI(matrix, 3, 3));
        System.out.println(MaxValueOfGiftsI_III(matrix, 3, 3));
        System.out.println(MaxValueOfGiftsII(matrix, 0, 0));
    }
}
