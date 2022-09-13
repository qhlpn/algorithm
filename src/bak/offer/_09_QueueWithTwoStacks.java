package bak.offer;

import java.util.Stack;

// 用两个栈来实现一个队列，
// 完成队列的Push和Pop操作。

public class _09_QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<Integer>(); //压入栈
    private Stack<Integer> stack2 = new Stack<Integer>(); //弹出栈

    ////////////////////////////////////////////////////////////////////
    // 思路：两个栈，负负为正
    // 把压入栈的内容倒入弹出栈 1.弹出栈空的时候才倒（故 '倒' 应写在pop函数里）
    //                      2.要倒就全部倒过去

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列已空！");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
