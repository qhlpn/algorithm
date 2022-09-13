package bak.offer;

// 在数组中的两个数字，如果前面一个数字大于后面的数字，
// 则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数 P。

public class _51_InversePairs {

    private static long count;

    public static int InversePairs(int[] array) {
        count = 0;
        Merge(array, 0, array.length - 1);
        return (int) (count % 1000000007);
    }

    public static void Merge(int[] array, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        Merge(array, l, mid);
        Merge(array, mid + 1, r);
        Merge(array, l, mid, r);
    }

    public static void Merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            if (array[p1] > array[p2]) {
                help[i++] = array[p1++];
                count += (r - p2 + 1);
            } else if (array[p1] == array[p2]) {
                help[i++] = array[p1++];
                count += (r - p2);
            } else {
                help[i++] = array[p2++];
            }
        }
        while (p1 <= mid)
            help[i++] = array[p1++];
        while (p2 <= r)
            help[i++] = array[p2++];
        for (i = 0; i < help.length; i++)
            array[l++] = help[i];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(InversePairs(array));
    }

}
