package bak.offer;

// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

// 原码、反码、补码
// 正数的三种码都一样
// +7 0111 0111 0111
// 负数的反码等于正数每位上的数取反、补码等于反码加一
// -7 1111 1000 1001
// 在计算机系统中，数值一律用补码来表示和存储
public class _15_NumberOfOneInBinary {

    //////////////////////////////////////////////////////////
    // 1、输入的整数进行右移，整数 1 不动，进行位与运算
    // 弊端：负数会死循环  (最高位负数1永远不会变，最终0xFFFF)

    //////////////////////////////////////////////////////////
    // 2、输入的整数不动，整数 1 左移，进行位与运算
    // 时间 O(N)     (int 32位，0x1...000  再左移就成 0 了)
    public static int NumberOfOneI(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) == flag) count++;
            flag = flag << 1;
        }
        return count;
    }

    //////////////////////////////////////////////////////////
    // 把一个整数减去 1 之后再和原来的整数进行位与运算，得到的结果
    // 相当于把整数的二进制表示中最右边的 1 变成 0
    // 1100 & (1100-1) = 1000
    public static int NumberOfOneII(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfOneII(9));
    }
}
