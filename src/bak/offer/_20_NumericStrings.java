package bak.offer;

// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

public class _20_NumericStrings {

    //////////////////////////////////////////////////////////
    // 解法1、库函数法(笑 cry)
    public boolean isNumericI(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //////////////////////////////////////////////////////////
    //解法2、正则表达式
    //    \\+  \\-  \\.  转义成字符  + - .
    //    [ ]   方格中的内容取一个
    //    ？    问号前的内容最多可以出现一次
    //    *     星号前的内容可以出现任意次
    public boolean isNumericII(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    //////////////////////////////////////////////////////////
    //解法3、表示数字的字符串遵循模式
    //      A[.[B]][e|EC]  .B[e|EC]
    //      从前往后扫描
    public boolean isNumericIII(char[] str) {
        if (str == null || str.length == 0) return false;
        int[] index = {0};
        // 1、首先尽可能地扫描 0~9 的数位(开头可以有'+'、'-')，代表A部分
        boolean numeric = scanInteger(str, index);
        // 2、如果遇到小数点 '.' ,则开始扫描表示数值的小数点部分，即B部分(数值前面不能有'+'、'-')
        if (index[0] <= str.length - 1 && str[index[0]] == '.') {
            index[0]++;
            // 用 或 运算，三种情况都正确
            // 小数点前面有数，后面没数   1. --> 1.0
            // 前面没数，后面有数        .1 --> 0.1
            // 前面、后面都有数         1.1 --> 1.1
            numeric = scanUnsignedInteger(str, index) || numeric;
        }
        // 3、如果遇到 'e、E' ,则开始扫描指数部分，即C部分
        if (index[0] <= str.length - 1 && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            // 用 与 运算
            // e / E 前面没 数字 则出错    .e1 、e1
            // e / E 后面没 整数 则出错    12e 、12e+5.4
            numeric = scanInteger(str, index) && numeric;
        }
        return numeric && index[0] == str.length;
    }

    public boolean scanInteger(char[] str, int[] index) {
        if (index[0] <= str.length - 1 && (str[index[0]] == '+' || str[index[0]] == '-')) index[0]++;
        return scanUnsignedInteger(str, index);
    }

    public boolean scanUnsignedInteger(char[] str, int[] index) {
        int before = index[0];
        while (index[0] <= str.length - 1 && str[index[0]] >= 48 && str[index[0]] <= 57) index[0]++;
        return (index[0] > before);
    }
}
