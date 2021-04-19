package leetcode.bfs;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组黑名单数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * @author QiuHongLong
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        String init = "0000";
        if (set.contains(init)) return -1;
        queue.add(init);
        set.add(init);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (target.equals(s)) return step;
                List<String> nexts = nextStep(s);
                for (String next : nexts) {
                    if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> nextStep(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) return res;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            char[] neigbors = neighborChar(c);
            assert neigbors != null;
            chars[i] = neigbors[0];
            res.add(String.valueOf(chars));
            chars[i] = neigbors[1];
            res.add(String.valueOf(chars));
            chars[i] = c;
        }
        return res;
    }

    private char[] neighborChar(char c) {
        if (c < '0' || c > '9') return null;
        char[] chars = new char[2];
        chars[0] = (c + 1) > '9' ? '0' : (char) (c + 1);
        chars[1] = (c - 1) < '0' ? '9' : (char) (c - 1);
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(new OpenTheLock().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }


}
