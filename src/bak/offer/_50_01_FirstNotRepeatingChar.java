package bak.offer;


// ��һ���ַ���
// (0<=�ַ�������<=10000��ȫ������ĸ���)
// ���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
// ���û���򷵻� -1����Ҫ���ִ�Сд��.
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
