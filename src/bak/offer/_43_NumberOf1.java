package bak.offer;

// ����һ������ n���� 1~n �� n ��������ʮ���Ʊ�ʾ�� 1 ���ֵĴ�����

public class _43_NumberOf1 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int help = i;
            while (help != 0) {
                if (help % 10 == 1) count++;
                help = help / 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(12));
    }
}
