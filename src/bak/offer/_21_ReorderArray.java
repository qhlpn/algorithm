package bak.offer;

// ����һ���������飬ʵ��һ�����������������������ֵ�˳��
// ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
// ����֤������������ż����ż��֮������λ�ò��䡣

public class _21_ReorderArray {

    //////////////////////////////////////////////////////
    // �����жϣ��ó����֣�������ǰŲ��һλ�����ַ������һ��
    // ʱ�� O(N^2)
    public static void reOrderArrayI(int[] array) {
        if (array == null || array.length == 0) return;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[index] % 2 == 0) {
                int temp = array[index];
                int help = index;
                while (help < array.length - 1) {
                    array[help] = array[help + 1];
                    help++;
                }
                array[array.length - 1] = temp;
            } else index++;
        }
    }

    //////////////////////////////////////////////////////
    // ˫ָ�룬һ��ǰ����һ������ǰ
    // ʱ�� O(N) �޷�ʵ�����λ�ò���
    // ���� �����һϵ��ͬ���������ͨ�÷���
    // C������ָ��  Java�����䣿
    public static void reOrderArrayII(int[] arr) {
        int f = 0;
        int l = arr.length - 1;
        int temp;
        while (f < l) {
            if (arr[f] % 2 == 1) {
                f++;
            } else {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l--] = temp;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 1, 1, 7};
        reOrderArrayII(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
