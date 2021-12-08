package leetcode.string;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        ArrayList<LinkedList<Character>> arrays = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arrays.add(new LinkedList<>());
        }

        Direct direct = Direct.DOWN;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (direct) {
                case DOWN:
                    arrays.get(level).add(s.charAt(i));
                    direct = level == numRows - 1 ? Direct.LEFT_UP : Direct.DOWN;
                    level = level == numRows - 1 ? level - 1 : level + 1;
                    break;
                case LEFT_UP:
                    arrays.get(level).add(s.charAt(i));
                    direct = level == 0 ? Direct.DOWN : Direct.LEFT_UP;
                    level = level == 0 ? level + 1 : level - 1;
                    break;
                default:
            }
        }

        StringBuilder sb = new StringBuilder();
        for (LinkedList<Character> array : arrays) {
            for (Character c : array) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private enum Direct {
        DOWN, LEFT_UP,
    }


    public static void main(String[] args) {
        new ZigZagConversion().convert("AB", 1);
    }

}
