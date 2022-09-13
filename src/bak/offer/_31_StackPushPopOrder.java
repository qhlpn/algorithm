package bak.offer;

// 输入两个整数序列，第一个序列表示栈的压入顺序，
// 请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，
// 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）


import java.util.Stack;

public class _31_StackPushPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if ((popA == null || pushA == null)
                || (popA.length != pushA.length)
                || (popA.length == 0 || pushA.length == 0)) return false;
        Stack<Integer> help = new Stack<>();
        int pushIndex = 0;
        boolean flag = false;
        for (int popIndex = 0; popIndex < popA.length; popIndex++) {
            if (help.isEmpty() || (popA[popIndex] != help.peek())) {
                while (pushIndex < pushA.length && popA[popIndex] != pushA[pushIndex]) {
                    help.push(pushA[pushIndex]);
                    pushIndex++;
                    if (pushIndex == pushA.length) break;
                }
                if (pushIndex == pushA.length) break;
                pushIndex++;
            } else help.pop();
            if (popIndex == popA.length - 1) flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder2(push, pop));
    }

    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (true) {
            if (stack.isEmpty() || stack.peek() != popA[i]) {
                if (j == pushA.length) {
                    return false;
                }
                stack.push(pushA[j++]);
            } else {
                stack.pop();
                i++;
            }
            if (i == popA.length && j == pushA.length) {
                return true;
            }
            if (i == popA.length && j != pushA.length) {
                return false;
            }
        }
    }


}
