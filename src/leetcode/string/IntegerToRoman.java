package leetcode.string;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 整数转罗马数字
 *
 * @author QiuHongLong
 */
public class IntegerToRoman {

    public String intToRoman(int num) {

        TreeMap<Integer, String> tm = new TreeMap<>(Comparator.comparingInt(l -> l));
        tm.put(1, "I");
        tm.put(4, "IV");
        tm.put(5, "V");
        tm.put(9, "IX");
        tm.put(10, "X");
        tm.put(40, "XL");
        tm.put(50, "L");
        tm.put(90, "XC");
        tm.put(100, "C");
        tm.put(400, "CD");
        tm.put(500, "D");
        tm.put(900, "CM");
        tm.put(1000, "M");

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (num <= 0) break;
            // floor -> 左边
            Entry<Integer, String> entry = tm.floorEntry(num);
            Integer key = entry.getKey();
            String value = entry.getValue();
            sb.append(value);
            num = num - key;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3));
    }

}
