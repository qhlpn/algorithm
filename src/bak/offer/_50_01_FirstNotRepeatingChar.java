package bak.offer;


// 在一个字符串
// (0<=字符串长度<=10000，全部由字母组成)
// 中找到第一个只出现一次的字符,并返回它的位置,
// 如果没有则返回 -1（需要区分大小写）.
public class _50_01_FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str == "") return -1;
        char[] chars = str.toCharArray();
        int[] count = new int[58];
        for (int i = 0; i < 58; i++)
            count[i] = 0;
        for (int i = 0; i < chars.length; i++)
            count[chars[i] - 65]++;
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 65] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("go"));
    }
}
