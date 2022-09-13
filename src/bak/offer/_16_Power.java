package bak.offer;

// ����һ��double���͵ĸ�����base��int���͵�����exponent��
// ��base��exponent�η���(����Ҫ���Ǵ�������)

public class _16_Power {

    //////////////////////////////////////////////////////////
    // ���Ҫ����ȫ
    // ʱ�� O(N)
    public static double PowerI(double base, int exponent) {
        double temp = base;
        if (exponent > 0) {
            for (int i = 0; i < exponent - 1; i++)
                base = base * temp;
            return base;
        } else if (exponent == 0) {
            return 1;
        } else {
            try {
                if (base == 0) {
                    System.out.println("xxxx");
                    throw new Exception("����");
                }
            } catch (Exception e) {

            }

            exponent = -exponent;
            for (int i = 0; i < exponent - 1; i++)
                base = base * temp;
            return 1 / base;
        }
    }

    //////////////////////////////////////////////////////////
    // �˷� N �ο��õݹ� (N/2)^2
    // ʱ�临�Ӷȱ�� O(logn)
    public static double PowerII(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            if (exponent == 1) return base;
            // ��λ������������࣬���������������� 2
            if ((exponent & 1) == 0) {
                return PowerII(base, exponent >> 1) * PowerII(base, exponent >> 1);
            } else {
                return PowerII(base, exponent >> 1) * PowerII(base, exponent >> 1) * base;
            }
        } else {
            if (exponent == -1) return 1 / base;
            if ((exponent & 1) == 0) {
                //   -1 / 2 = -1 (��С�Ŀ�)
                return PowerII(base, (exponent >> 1) + 1) * PowerII(base, (exponent >> 1) + 1);
            } else {
                return PowerII(base, (exponent >> 1) + 1) * PowerII(base, (exponent >> 1) + 1) / base;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(PowerI(0, -3));
    }
}
