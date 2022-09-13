package bak.offer;

// ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
// ����һ����������������һ����ת�������ת�������СԪ�ء�
// �������� {3,4,5,1,2} Ϊ {1,2,3,4,5} ��һ����ת�����������СֵΪ1��
// NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
public class _11_MinNumberInRotatedArray {

    //////////////////////////////////////////////////////////
    // ��������б�������
    // ʱ�� O(N)
    // ע������ != ����
    public static int minNumberInRotateArrayI(int[] array) {
        if (array.length == 0) return 0;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    //////////////////////////////////////////////////////////
    // ˼·�����ź��򣨻򲿷��ź��򣩵�������в��ң�
    //      �뵽ʹ�ö��ֲ��ҷ�(��λ���������η����������)
    // ������ת��������������ö��ֲ��ҷ� ʱ��O(logN)
    // ���ֲ��ҡ��������� {3,4,5,1,2} --> {5,1}
    // ע��㣺1����λ�������--> pre ~ in �� in ~ pos
    //       2����ʱ���أ�--> �� pos - pre == 1ʱ������ array[pos]
    //       3���� array[pre] == array[pos] ʱ��ֻ�ܸ���˳�����
    //                              {1,0,1,1,1} �� {1,1,1,0,1}
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
