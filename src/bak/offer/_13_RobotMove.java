package bak.offer;

// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
// 每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格（35,37），因为 3+5+3+7 = 18。
// 但是，它不能进入方格（35,38），因为 3+5+3+8 = 19。
// 请问该机器人能够达到多少个格子？
public class _13_RobotMove {

    //////////////////////////////////////////////////////////
    // 二维方格运动问题 --> 回溯法
    // 回溯法关键点 --> 标志位、进行的条件、信息的收集、扣边界
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        // 能达到的格子数
        int[] count = {0};
        getCount(rows, cols, 0, 0, count, flag, threshold);
        return count[0];
    }

    public static void getCount(int rows, int cols, int i, int j, int[] count, boolean[][] flag, int threshold) {
        // 越边界、已访问、超过阈值 则出错
        if (i < 0 || i == rows || j < 0 || j == cols || flag[i][j] || initialize(i, j) > threshold) return;
        // 满足条件的格子数加1
        count[0]++;
        // 标志位设为true，已访问
        flag[i][j] = true;
        // 对 当前点 的周围四个点进行判断
        getCount(rows, cols, i, j + 1, count, flag, threshold);
        getCount(rows, cols, i + 1, j, count, flag, threshold);
        getCount(rows, cols, i, j - 1, count, flag, threshold);
        getCount(rows, cols, i + 1, j, count, flag, threshold);
        return;
    }

    // 计算行坐标和列坐标的数位之和
    public static int initialize(int i, int j) {
        int num = 0;
        while (i > 0) {
            num += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            num += j % 10;
            j = j / 10;
        }
        return num;
    }

}
