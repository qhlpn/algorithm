package bak.offer;

// 给定一个double类型的浮点数base和int类型的整数exponent。
// 求base的exponent次方。(不需要考虑大数问题)

public class _16_Power {

    //////////////////////////////////////////////////////////
    // 情况要考虑全
    // 时间 O(N)
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
                    throw new Exception("出错");
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
    // 乘方 N 次可用递归 (N/2)^2
    // 时间复杂度变成 O(logn)
    public static double PowerII(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            if (exponent == 1) return base;
            // 用位于运算代替求余，用右移运算代替除以 2
            if ((exponent & 1) == 0) {
                return PowerII(base, exponent >> 1) * PowerII(base, exponent >> 1);
            } else {
                return PowerII(base, exponent >> 1) * PowerII(base, exponent >> 1) * base;
            }
        } else {
            if (exponent == -1) return 1 / base;
            if ((exponent & 1) == 0) {
                //   -1 / 2 = -1 (往小的靠)
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
