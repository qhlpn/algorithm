package bak.offer;

import java.util.Stack;

// ����ջ�����ݽṹ
// ���ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min����
// (ʱ�临�Ӷ�ӦΪ O(1))

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
