package bak.offer;

// ��1+2+3+...+n��Ҫ����ʹ��
// �˳�����for��while��if��else��switch��case�ȹؼ���
// �� �����ж���䣨A?B:C��

public class _64_Accumulate {

    // ˼·��
    // �����ó˷� --> ����ѭ���ۼ� -->
    // ������ѭ�� --> ���õݹ��� -->
    // �ݹ�Ҫ�г��ڣ����������ж���� --> ʹ�ö�·�﷨

    public int Sum_Solution(int n) {
        boolean t =
                (n != 0) && ((n += Sum_Solution(n - 1)) != 0);
        return n;
    }
}
