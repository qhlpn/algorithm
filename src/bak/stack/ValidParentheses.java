package bak.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 *
 * @author QiuHongLong
 */
public class ValidParentheses {


    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        HashSet<Character> push = new HashSet<>();
        push.add('(');
        push.add('{');
        push.add('[');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (push.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        // [
        // ]
        // []
        System.out.println(new ValidParentheses().isValid("]"));
    }

}
