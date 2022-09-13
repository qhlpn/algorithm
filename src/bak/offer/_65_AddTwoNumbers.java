package bak.offer;

// 写一个函数，求两个整数之和
// 要求在函数体内不得使用 +、-、*、/ 四则运算符号。

public class _65_AddTwoNumbers {

    // 思路：位运算
    // 第一步：加法（不含进位） --> 异或
    // 第二步：进位 --> 与运算 + 左移 1 位
    // 第三步：进位后可能再次进位（重回第一步）

    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
