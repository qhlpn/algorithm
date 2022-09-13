package bak.offer;

// 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
// 模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
// 但是与"aa.a"和"ab*a"均不匹配

public class _19_RegularExpressionsMatching {

    // https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
    // 当模式中的第二个字符不是“*”时：
    //      1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    //      2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    // 而当模式中的第二个字符是“*”时：
    // 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
    // 如果字符串第一个字符跟模式第一个字符匹配，可以有2种匹配方式：
    //      1、字符串不动，模式后移2字符，相当于 x* 被忽略
    //      2、字符串后移1字符，模式不动，继续匹配字符下一位

    //////////////////////////////////////////////////////////
    // 暴力递归(为什么可以用递归？暴力枚举？)
    // 递归是关于尝试的过程
    public static boolean match(char[] str, char[] pattern) {
        // 数组是引用类型
        // int[] c = null ; c.length == 0 ; java.lang.NullPointerException
        // int[] c = {}   ; c.length == 0 ; true
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        // pattern先到尾，匹配失败
        // str有机会先到尾  str = 'a' 、 pattern = 'ab*'
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        // 模式第2个是 *
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 字符串第1个跟模式第1个匹配,分3种匹配模式
            if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                // 模式后移2，视为 x* 匹配0个字符
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        // * 匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
                // 如不匹配，模式后移2位
            } else return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.'))
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        return false;
    }

    public static void main(String[] args) {
        char[] str = {'a'};
        char[] pattern = {'a', '.'};
        System.out.println(match(str, pattern));
    }
}
