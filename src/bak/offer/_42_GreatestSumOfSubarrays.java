package bak.offer;


// ����һ���������飬������������Ҳ�и�����
// �����е�һ������������������һ�������顣
// ������������͵����ֵ��
// Ҫ��ʱ�临�Ӷ�Ϊ O(n)
public class _42_GreatestSumOfSubarrays {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i]) sum = array[i];
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3};
        System.out.println(FindGreatestSumOfSubArray(array));

    }
}
