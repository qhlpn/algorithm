package bak.leetcode.stack;

import java.util.Stack;

/**
 * 有n个人站队，所有的人全部向右看，个子高的可以看到个子低的发型，给出每个人的身高，问所有人能看到其他人发现总和是多少。
 *
 * @author QiuHongLong
 */
public class FieldSum {

    public int fieldSum(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] <= current) {
                int lidx = stack.pop();
                res += (i - lidx - 1);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res += (arr.length - stack.pop() - 1);
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new FieldSum().fieldSum(new int[]{4, 3, 2, 2}));
    }

}
