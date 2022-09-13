package bak.offer;

// һֻ����һ�ο�������1��̨�ף�Ҳ��������2�� ���� Ҳ��������n����
// �����������һ��n����̨���ܹ��ж�����������

public class _10_03_FrogJumpFloorII {
    ////////////////////////////////////////////////////////////////////
    // �� n ��̨��������ʽ�� f(n)
    // f(n) = �� 1 ����1��̨�� + �� 1 ����2��̨�� + �� 1 ����3��̨�� + ... + �� 1 ����n��̨��
    // f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(0)     --- ��
    // f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(0)   --- ��
    // �� - �� --> f(n) = 2f(n-1) = 2^(n-1)
    // ֱ����⣺
    // ÿ��̨�׶������벻������������������һ��̨�ף������һ��̨�ױ����������Թ���2^(n-1)�����
    public static int jumpFloorRecur(int target) {
        if (target == 1) return 1;
        return 2 * jumpFloorRecur(target - 1);
    }

    public static int jumpFloorUnRecur(int target) {
        if (target == 1) return 1;
        int pre = 1;
        int pos = 0;
        for (int i = 2; i <= target; i++) {
            pos = 2 * pre;
            pre = pos;
        }
        return pos;
    }

    public static int process(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret += process(n - i);
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; ++i) {
            System.out.println(i);
            if (process(i) != jumpFloorUnRecur(i)) {
                System.out.println(false);
                break;
            }
        }
    }
}
