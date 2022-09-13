package bak.offer;

// ��һ�������г�һ������ֻ����һ��֮�⣬
// �������ֶ�����������
// ���ҳ��Ǹ�ֻ����һ�ε�����

public class _56_02_NumberAppearingOnce {

    public static int FindNumberAppearingOnce(int[] arr) {
        int[] help = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                help[j] += (arr[i] & 1);
                arr[i] = arr[i] >> 1;
            }
        }
        int resp = 0;
        for (int i = 0; i < 32; i++) {
            help[i] = (help[i] % 3 == 0) ? 0 : 1;
            resp += help[i] << i;
        }
        return resp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 7, 7, 7};
        System.out.println(FindNumberAppearingOnce(arr));

    }
}
