package bak.offer;


// ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
// ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ�
// �ܹ��ж����ַ�����
public class _10_04_RectCover {

    ////////////////////////////////////////////////////////////////////
    // �踲�� 2*n ������� f(n) �ַ���
    // ������࿪ʼ����
    // f(n) = �� 1 �����Ÿ��� + �� 1 �κ��Ÿ���
    // ����       ʣ2*(n-1)      ʣ2*(n-2) <-- ���Ÿ���1�������·��ռ�ֻ�ܺ��Ÿ���
    // f(n) = f(n-1) + f(n-2)
    // ��ʵ����쳲���������
    public static int rectCoverRecur(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return rectCoverRecur(target - 1) + rectCoverRecur(target - 2);
    }

    public static int rectCoverUnRecur(int target) {
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
