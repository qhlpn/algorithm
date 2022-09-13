package bak.offer;

// ����һ������Ϊn�����ӣ�������Ӽ���m�� (m��n����������n>1����m>1)
// ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1],...,k[m].
// ���� k[0]*k[1]*...*k[m] ���ܵ����˻��Ƕ��٣�
// ���磬�����ӵĳ���Ϊ8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2,3,3�����Σ���ʱ�õ������˻���18.

public class _14_CuttingRope {

    //////////////////////////////////////////////////////////
    // �ݹ�� f(n) = max(f(i)*f(n-i))
    // ����з���Ҫ���ײ����������������з֣���������������з֣�����
    // ��γ����ײ��ǹؼ�
    //    private static boolean cut = false;
    //    public static int error(int length) {
    //        if (length == 1 || length == 0) return 1;
    //        int max = length;
    //        if (cut && length == 2) return 2;
    //        if (cut && length == 3) return 3;
    //        if (!cut && (length == 2 || length == 3)) max = 0;
    //        cut = true;
    //        int flag = 0;
    //        // �зֵ������Ǵ������ϣ������ɴ������£�����
    //        for (int i = 1; i < length; i++) {
    //            if (max <= i * (length - i)) {
    //                max = i * (length - i);
    //                flag = i;
    //            }
    //        }
    //        return error(flag) * error(length - flag);
    //    }

    // �����ݹ�(ö��)�� f(n) = max(f(i)*f(n-i))
    private static boolean cut = false;

    public static int maxProductAfterCuttingI(int length) {
        if (!cut) {
            if (length == 0) return 0;
            if (length == 1) return 0;
            if (length == 2) return 1;
            if (length == 3) return 2;
        }
        cut = true;
        if (length == 1) return 1;
        if (length == 2) return 2;
        if (length == 3) return 3;
        int[] record = new int[length / 2 + 1];
        // ����ö�ٳ���
        for (int i = 1; i < length / 2 + 1; i++) {
            record[i] = maxProductAfterCuttingI(i) * maxProductAfterCuttingI(length - i);
        }
        int max = 0;
        for (int i = 1; i < length / 2 + 1; i++) {
            if (max < record[i]) max = record[i];
        }
        return max;
    }

    //////////////////////////////////////////////////////////
    // �����ݹ�ĳɶ�̬�滮
    // ��·��1�����ݱ����ĸ�����ȡֵ��Χ����
    //        --> �������ֻ�� length һ��(��ָ�����Ĵ��α������е�i����)��ȡֵ��Χ��[0~length]
    //            �ʽ�һά�ı������飬��С new int[length + 1]
    //      2������������basecase�����
    //        --> ����basecase�� maxArray[1] = 1; maxArray[2] = 2; maxArray[3] = 3;
    //      3������ basecase �� ��Ŀ������ ���ľ���ѱ������������������һ��˵������
    //        --> ��Ŀ������max(f(n)*f(n-1))
    //            ���ص���һ��˵������� maxArray[length]
    // ʱ�� O(N2) �ռ� O(N)
    public static int maxProductAfterCuttingII(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] maxArray = new int[length + 1];
        maxArray[1] = 1;
        maxArray[2] = 2;
        maxArray[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (max < maxArray[j] * maxArray[i - j])
                    max = maxArray[j] * maxArray[i - j];
            }
            maxArray[i] = max;
        }
        return maxArray[length];
    }

    //////////////////////////////////////////////////////////
    // ̰���㷨
    // ���ӳ��� >= 5ʱ��ÿ���е� 3;ֱ�� < 5
    // ʱ�� O(N) �ռ� O(1)
    public static int maxProductAfterCuttingIII(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        if (length == 4)
            return 4;
        int max = 1;
        while (length >= 5) {
            max = max * 3;
            length = length - 3;
        }
        return (max = max * length);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            System.out.print(i + " ");
            if (maxProductAfterCuttingII(i) != maxProductAfterCuttingI(i) ||
                    maxProductAfterCuttingII(i) != maxProductAfterCuttingIII(i)) {
                System.out.println("Fucking Fucked!");
            }
        }
        System.out.println();
        System.out.println("Nice!");
    }
}
