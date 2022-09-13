package bak.offer;

// ���������������Ե�����ֵ

public class _63_MaximalProfit {
    // ˼·һ������ O(N2)

    // ˼·�����ռ任ʱ��  O(N)
    //        ������������ 1����֮ǰ��С��ֵ
    //                   2������ֵ����ǰֵ��֮ǰ��Сֵ�Ĳ� �����ֵ��
    public static int MaximalProfit(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            maxDiff = arr[i] - min > maxDiff ? arr[i] - min : maxDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(MaximalProfit(arr));
    }

}
