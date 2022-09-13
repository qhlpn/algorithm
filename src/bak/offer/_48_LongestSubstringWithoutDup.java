package bak.offer;

import java.util.ArrayList;

// 最长不含重复字符的子字符串
public class _48_LongestSubstringWithoutDup {

    public static int LongestSubstringWithoutDup(String string) {
        char[] chars = string.toCharArray();
        ArrayList<Integer> al = new ArrayList();
        Recur(chars, chars.length - 1, al);
        int max = -1;
        for (int i = 0; i < al.size(); i++)
            if (max < al.get(i)) max = al.get(i);
        return max;
    }

    public static int Recur(char[] chars, int index, ArrayList<Integer> al) {
        if (index == 0) {
            al.add(1);
            return 1;
        }
        int distance = 0;
        boolean flag = false;
        for (int i = index - 1; i >= 0; i--) {
            if (chars[i] == chars[index]) {
                flag = true;
                distance = index - i;
                break;
            }
        }
        if (!flag) {
            int length = Recur(chars, index - 1, al) + 1;
            al.add(length);
            return length;
        } else if (flag && distance > Recur(chars, index - 1, al)) {
            int length = Recur(chars, index - 1, al) + 1;
            al.add(length);
            return length;
        } else {
            al.add(distance);
            return distance;
        }
    }

    public static void main(String[] args) {
        String str = "abcc";
        System.out.println(LongestSubstringWithoutDup(str));
    }
}
