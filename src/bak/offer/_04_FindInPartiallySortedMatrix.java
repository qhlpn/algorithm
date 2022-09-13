package bak.offer;

// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
// 判断数组中是否含有该整数。

public class _04_FindInPartiallySortedMatrix {

    ////////////////////////////////////////////////////////////////////
    // 1、 有序 --> 二分查找  时间 O(nlogn) 空间 O(1)
    // 注意 二分查找的细节:
    // while (min <= max)
    // 划分成 min ~ mid - 1 , mid , mid + 1 ~ max
    // mid = min + ((max - min) >> 1) 中
    // 运算符 + >> 是同级的，从左往右，故需要加括号
    public static boolean find_1(int[][] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (binary_search(arr[i], x)) return true;
        }
        return false;
    }

    public static boolean binary_search(int[] arr, int x) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = min + ((max - min) >> 1);
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }


    ////////////////////////////////////////////////////////////////////
    // 最优解：根据条件（上到下、左到右均有序）
    // --> x > arr 则 右边 + 上边
    // --> x < arr 则 左边 + 下边
    // 每种情况会射出 2 个方向，无法操作
    // 解决的思路: 倚靠住边界，从 右上角 / 左下角 出发
    // 时间 O(m+n) ~ O(n)
    public static boolean find_2(int[][] arr, int x, int[] resp) {
        int row = arr.length;
        int col = arr[0].length;

        int r = 0;
        int c = col - 1;

        while (r != row && c != -1) {
            if (x > arr[r][c]) {
                r++;
            } else if (x < arr[r][c]) {
                c--;
            } else {
                resp[0] = arr[r][c];
                resp[1] = r;
                resp[2] = c;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int x = 16;
//        int[] resp = new int[3];
//        if (find_2(arr, x, resp)) {
//            System.out.println("arr[" + resp[1] + "][" + resp[2] + "] = " + resp[0]);
//        } else {
//            System.out.println("数组中不含有 " + x);
//        }
        if (find_1(arr, x)) {
            System.out.println("数组中含有 " + x);
        } else {
            System.out.println("数组中不含有 " + x);
        }
    }

}
