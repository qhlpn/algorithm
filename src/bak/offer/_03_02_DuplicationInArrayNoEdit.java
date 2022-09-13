package bak.offer;


// ���޸������ҳ�����������һ���ظ������֣��ش��ڣ�
// ��һ������Ϊ n + 1 ����������������ֶ��� 1 ~ n ��Χ

public class _03_02_DuplicationInArrayNoEdit {

    ////////////////////////////////////////////////////////////////////
    // 1�� ���ø������� (Ͷʯ��ڷ�)  _03_01_ Ҳ�ɲ���  ʱ�� O(n) �ռ� O(n)
    public static boolean duplicate_01(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            help[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == help[arr[i]]) {
                resp[0] = arr[i];
                return true;
            }
            help[arr[i]] = arr[i];
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////
    // 2�� ���ַ� + �ռ����ֳ��ִ���  (��������: ���鳤�� n+1�����ַ�Χ 1~n���������ӳ���2�� )
    //     ʱ�任�ռ�   ʱ�� O(nlogn)  �ռ� O(1)

    // ע�� ������ַ��ķ�Χ����  (��ͬ�ھ�����ֲ��ҷ� _04_ --> 3��if ����3��  < x | x | > x )
    // -->  min ~ mid , mid + 1 ~ max
    // -->  1 ~ 7 , min = 1 , max = 7 , mid = 4
    // -->  ����Ϊ  1 ~ 4 , 5 ~ 7

    // ������� min ~ mid , mid ~ max �������ѭ��
    // --> {1,2,2}  max = 2, min = 1, mid = 1
    // --> if (counts(arr, min, mid) > (mid - min + 1))     (num = 1) == 1
    //         max = mid;
    //     else
    //         min = mid;                                    min = mid = 1 (��ѭ��)
    //       ( min = mid + 1;)                               min = 2 (������ѭ��)


    public static boolean duplicate_02(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        int min = 1;
        int max = arr.length - 1;
        int mid;
        while (max > min) {
            mid = min + ((max - min) >> 1);
            if (counts(arr, min, mid) > (mid - min + 1))
                max = mid;
            else
                min = mid + 1;
        }
        resp[0] = max;
        return true;
    }

    public static int counts(int[] arr, int min, int max) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 2, 6, 7};
        int[] resp = new int[1];
        boolean flag = duplicate_02(arr, resp);
        if (flag) {
            System.out.println("�ظ��������� " + resp[0]);
        } else {
            System.out.println("��������ַ�Χ����");
        }
    }
}
