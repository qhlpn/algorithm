package bak.offer;

// 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
// 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
// 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
// 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串 "bcced" 的路径，
// 但是矩阵中不包含 "abcb" 路径，
// 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

public class _12_StringPathInMatrix {

    //////////////////////////////////////////////////////////
    // 思路：回溯法（深度优先搜索DFS的一种）
    //      二维方格运动问题常用（走迷宫等）
    // 区别：回溯法在求解过程中不保留完整的树结构，而深度优先搜索则记下完整的搜索树。
    //      回溯法 等同 在深度优先搜索中用标志的方法记录访问过的状态（减少存储空间） boolean flag[]
    // 回溯法关键点 --> 标志位、进行的条件、信息的收集、扣边界
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean flag[] = new boolean[matrix.length];
        // 对 矩阵每个点作为起点 进行尝试
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    // k：匹配到了str[k]
    // flag：标志位，记录访问过的矩阵点  防止二次访问
    //      在收录搜索路径中的才置 true （剑指Offer P88 讲错了）
    //      str{a,e,g,h,u} 搜索路径即str {a,e,g,-->}  此时只有 a、e、g置true，四周的点不置
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag) {
        // 索引的转化 --> 一维矩阵模拟二维矩阵
        int index = i * cols + j;
        // ===== 先判断当前点是否满足要求 =========

        // ===== 当前点不满足要求的情况下 =====
        // 坐标越界 (i < 0 || i >= rows || j < 0 || j >= cols）
        // 路径上的点与目标不相等 (matrix[index] != str[k])
        // 已经访问过矩阵上的此点 (flag[index])  则出错
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) return false;

        // ===== 当前点满足要求的情况下 =======
        // 判断是否已经匹配目标路径所有的字符
        if (k == str.length - 1) return true;
        // 标志位记录访问过的矩阵点(当前点)
        flag[index] = true;
        // 对 当前点 周围四个点进行下一步搜索
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) return true;
        // 当前点 周围四个点没一个合适 ，回溯当前点的上个点
        // 当前点标志位清空
        flag[index] = false;
        return false;
    }


    public boolean process() {

        return true;
    }








}
