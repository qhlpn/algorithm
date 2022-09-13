package bak.offer;


// һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
// �����������һ��n����̨���ܹ��ж���������
// ���Ⱥ����ͬ�㲻ͬ�Ľ������
public class _10_02_FrogJumpFloorI {

    ////////////////////////////////////////////////////////////////////
    // �� n ��̨��������ʽ�� f(n)
    // f(n) = �� 1 ����1��̨�� + �� 1 ����2��̨��
    //         ʣ n-1 ��̨��      ʣ n-2 ��̨��
    // �ݹ� --> f(n) = f(n-1) + f(n-2)
    // ��ʵ����쳲���������
    public static int jumpFloorRecur(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return jumpFloorRecur(target - 1) + jumpFloorRecur(target - 2);
    }

    public static int jumpFloorUnRecur(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int pre = 1;
        int in = 2;
        int pos = 0;
        for (int i = 3; i <= target; i++) {
            pos = pre + in;
            pre = in;
            in = pos;
        }
        return pos;
    }
}
