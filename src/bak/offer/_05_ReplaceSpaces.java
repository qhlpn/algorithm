package bak.offer;

// 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。
// 例如，当字符串为 We Are Happy.
// 则经过替换之后的字符串为 We%20Are%20Happy。

public class _05_ReplaceSpaces {
    ////////////////////////////////////////////////////////////////////
    // 1、在原来的字符串上（覆盖 --> 移动）
    // 从前往后
    // 假设字符串长度是n，对于每个空格字符，需要移动后面O(n)个字符，
    // 因此对于含有O(n)个空格字符的字符串而言
    // 时间O(n2) 空间O(1)

    ////////////////////////////////////////////////////////////////////
    // 2、用辅助的字符串上替换
    // 时间 O(n) 空间 O(n)

    ////////////////////////////////////////////////////////////////////
    // 3、在原来的字符串上（覆盖 --> 移动）
    // 从后往前 两指针赛跑
    // 所有的字符最多只需复制（移动）一次
    // 时间O(n) 空间O(1)
    // Java知识点: char[](数组固定长度) 、String(常量)
    //            StringBuffer(变量，线程安全) 、StringBuilder(变量，线程不安全)
    //            索引都是包含头、不包含尾
    public static String replaceBlank(StringBuffer str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') num++;
        }
        int pre = str.length() - 1;
        for (; num > 0; num--) {
            str.append("  ");
        }
        int pos = str.length() - 1;
        while (pre < pos) {
            if (str.charAt(pre) == ' ') {
                str.replace(pos - 2, pos + 1, "%20");
                pos = pos - 3;
                pre--;
            } else {
                str.replace(pos, pos + 1, str.substring(pre, pre + 1));
                pos--;
                pre--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Happy New Year!");
        System.out.println(sb);
        System.out.println(replaceBlank(sb));
    }
}
