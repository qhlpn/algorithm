package leetcode.string;


import java.math.BigInteger;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * @author QiuHongLong
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        BigInteger bia = new BigInteger(a, 2);
        BigInteger bib = new BigInteger(b, 2);
        BigInteger add = bib.add(bia);
        return add.toString(2);

    }

    public String addBinaryII(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("101010", "101010"));
    }

}
