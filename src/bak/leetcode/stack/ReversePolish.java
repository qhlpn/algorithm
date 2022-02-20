package bak.leetcode.stack;

import java.util.Stack;

/**
 * 逆波兰表达式，有效的算符包括 +、-、*、/
 * 执行操作时是后序表达式，即 左 右 父
 *
 * @author QiuHongLong
 */
public class ReversePolish {

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();

    }


}
