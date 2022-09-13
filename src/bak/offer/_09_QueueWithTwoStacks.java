package bak.offer;

import java.util.Stack;

// ������ջ��ʵ��һ�����У�
// ��ɶ��е�Push��Pop������

public class _09_QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<Integer>(); //ѹ��ջ
    private Stack<Integer> stack2 = new Stack<Integer>(); //����ջ

    ////////////////////////////////////////////////////////////////////
    // ˼·������ջ������Ϊ��
    // ��ѹ��ջ�����ݵ��뵯��ջ 1.����ջ�յ�ʱ��ŵ����� '��' Ӧд��pop�����
    //                      2.Ҫ����ȫ������ȥ

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("�����ѿգ�");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
