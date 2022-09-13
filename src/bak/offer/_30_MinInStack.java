package bak.offer;

import java.util.Stack;

// 定义栈的数据结构
// 请在该类型中实现一个能够得到栈中所含最小元素的min函数
// (时间复杂度应为 O(1))

public class _30_MinInStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!min.isEmpty() && min.peek() < node) {
            min.push(min.peek());
        } else min.push(node);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
