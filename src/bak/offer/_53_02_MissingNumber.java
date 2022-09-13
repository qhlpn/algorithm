package bak.offer;

// �ڳ���Ϊ n-1 �ĵ���������
// �� 0 ~ n-1 ��ȱʧ������

public class _53_02_MissingNumber {
    public static int MissingNumber(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] != mid) {
                if (arr[mid - 1] == mid - 1)
                    return mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3};
        System.out.println(MissingNumber(arr));
    }
}
