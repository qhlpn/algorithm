package leetcode.list.array;

import java.math.BigInteger;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * @author QiuHongLong
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        BigInteger bi = new BigInteger(sb.toString());
        BigInteger biCal = bi.add(BigInteger.valueOf(1));
        String cal = biCal.toString();

        int[] res = new int[cal.length()];
        for (int i = 0; i < cal.length(); i++) {
            res[i] = Integer.parseInt(String.valueOf(cal.charAt(i)));
        }

        return res;
    }

    public int[] plusOneV2(int[] digits) {

        int[] res = new int[digits.length + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }

        int index = res.length - 1;
        int sum;
        int carry = 1;
        do {
            sum = res[index] + carry;
            carry = sum / 10;
            res[index] = sum % 10;
            index--;
        } while (carry == 1);

        if (res[0] != 1) {
            for (int i = 1; i < res.length; i++) {
                digits[i - 1] = res[i];
            }
            return digits;
        }

        return res;
    }


    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9});
    }
}
