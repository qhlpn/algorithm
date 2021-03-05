package leetcode.string;

import java.math.BigInteger;

public class StringtoInteger {

    public int myAtoi(String s) {

        if (s == null) {
            return 0;
        }

        long total = 0;
        long bit;
        boolean isPositive = true;
        boolean meetNum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                meetNum = true;
                bit = c - '0';
                total = total * 10 + bit;
                if (isPositive && total >= Long.MAX_VALUE / 10) {
                    break;
                }
                if (!isPositive && -total <= Long.MIN_VALUE / 10) {
                    break;
                }
            } else {
                if (meetNum) {
                    break;
                } else {
                    if (c == ' ') {
                        continue;
                    }
                    if (c != '+' && c != '-') {
                        break;
                    } else {
                        isPositive = c == '+';
                        meetNum = true;
                    }
                }
            }
        }


        total = isPositive ? total : -total;

        if (total > Integer.MAX_VALUE) {
            total = Integer.MAX_VALUE;
        }
        if (total < Integer.MIN_VALUE) {
            total = Integer.MIN_VALUE;
        }

        return (int)total;

    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        new StringtoInteger().myAtoi("9223372036854775808");
    }


//    BigInteger
//    public int myAtoi(String s) {
//
//        if (s == null) {
//            return 0;
//        }
//
//        BigInteger total = BigInteger.valueOf(0);
//        BigInteger bit;
//        boolean isPositive = true;
//        boolean meetNum = false;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (isNumber(c)) {
//                meetNum = true;
//                bit = BigInteger.valueOf(c - '0');
//                total = total.multiply(BigInteger.valueOf(10)).add(bit);
//            } else {
//                if (meetNum) {
//                    break;
//                } else {
//                    if (c == ' ') {
//                        continue;
//                    }
//                    if (c != '+' && c != '-') {
//                        break;
//                    } else {
//                        isPositive = c == '+';
//                        meetNum = true;
//                    }
//                }
//            }
//        }
//
//        total = isPositive ? total : total.multiply(BigInteger.valueOf(-1));
//
//        if (total.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
//            total = BigInteger.valueOf(Integer.MAX_VALUE);
//        }
//        if (total.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
//            total = BigInteger.valueOf(Integer.MIN_VALUE);
//        }
//
//        return total.intValue();
//
//    }

}
