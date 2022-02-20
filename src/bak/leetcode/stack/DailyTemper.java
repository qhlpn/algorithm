package bak.leetcode.stack;

import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用  0 来代替。
 * 例如，给定一个列表  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是  [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * @author QiuHongLong
 */
public class DailyTemper {


    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < current) {
                int lidx = stack.pop();
                res[lidx] = i - lidx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
    }

    public static void main(String[] args) {
        new DailyTemper().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }


}
