package bak.offer;

// ��n���������ڵ��ϣ�
// �������ӳ���һ��ĵ���֮��ΪS��
// ����n����ӡ��S�����п��ܵ�ֵ���ֵĸ��ʡ�

public class _60_DicesProbability {


    // ˼·��
    // 1��n�������ܿ����� 6^n
    // 2��n�����ӵ�����Ϊs�����Ϊ f(n,s)
    //    f(n,s)=f(n-1.s-1)+f(n-1.s-2)+f(n-1.s-3)+f(n-1.s-4)+f(n-1.s-5)+f(n-1.s-6)

    public static int getSumCountI(int n, int s) {
        if (s < n || s > 6 * n || s == 0 || n == 0) {
            return 0;
        }
        if (n == 1 && s <= 6) {
            return 1;
        }
        return getSumCountI(n - 1, s - 1) + getSumCountI(n - 1, s - 2) +
                getSumCountI(n - 1, s - 3) + getSumCountI(n - 1, s - 4) +
                getSumCountI(n - 1, s - 5) + getSumCountI(n - 1, s - 6);
    }


    public static double probabilityI(int n, int s) {
        return getSumCountI(n, s) / Math.pow(6, n);
    }

    // ��̬�滮��
    // 1������2�� --> ����2ά����
    // 2����������Ҫ��ĵ�  dp[n][s]
    // 3���ѻ����ı߽綨�����  dp[1][1-6]=1
    // 4����ʼ����ľ
    public static int getSumCountII(int n, int s) {
        if (s < n || s > 6 * n || n == 0 || s == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] matrix = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            matrix[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                int index = j;
                while (--index >= i - 1 && index >= j - 6) {
                    matrix[i][j] += matrix[i - 1][index];
                }
                if (i == n && j == s) {
                    return matrix[i][j];
                }
            }
        }
        return 0;
    }

    public static double probabilityII(int n, int s) {
        return getSumCountII(n, s) / Math.pow(6, n);
    }

    public static void main(String[] args) {
        _60_DicesProbability test = new _60_DicesProbability();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 40; j++) {
                if (test.getSumCountII(i, j) != test.getSumCountI(i, j)) {
                    System.out.println("fuck " + i + " " + j + " " + test.getSumCountII(i, j) + " " + test.getSumCountI(i, j));
                }
            }
        }

//        System.out.println(getSumCountII(2, 12));
    }
}
