package bak.offer;

// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为1。
// NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class _11_MinNumberInRotatedArray {

    //////////////////////////////////////////////////////////
    // 对数组进行遍历查找
    // 时间 O(N)
    // 注：查找 != 排序
    public static int minNumberInRotateArrayI(int[] array) {
        if (array.length == 0) return 0;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    //////////////////////////////////////////////////////////
    // 思路：对排好序（或部分排好序）的数组进行查找，
    //      想到使用二分查找法(如何划分区域、如何返回因题而异)
    // 根据旋转数组的条件，采用二分查找法 时间O(logN)
    // 二分查找、区域收缩 {3,4,5,1,2} --> {5,1}
    // 注意点：1、如何划分区域？--> pre ~ in 、 in ~ pos
    //       2、何时返回？--> 当 pos - pre == 1时，返回 array[pos]
    //       3、当 array[pre] == array[pos] 时，只能改用顺序查找
    //                              {1,0,1,1,1} 、 {1,1,1,0,1}
    public static int minNumberInRotateArrayII(int[] array) {
        if (array.length == 0) return 0;
        int pre = 0;
        int pos = array.length - 1;
        int in = 0;
        while (pre <= pos) {
            if (pos - pre == 1) return array[pos];
            in = pre + ((pos - pre) >> 1);
            if (array[pre] == array[pos]) {
                int min = array[pre];
                for (int i = pre; i <= pos; i++) {
                    if (min > array[i]) min = array[i];
                }
                return min;
            }
            if (array[in] >= array[pre]) pre = in;
            if (array[in] < array[pre]) pos = in;

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArrayI(array));
    }
}
