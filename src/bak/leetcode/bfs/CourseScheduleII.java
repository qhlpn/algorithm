package bak.leetcode.bfs;

import java.util.*;

// 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
// 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
public class CourseScheduleII {

    // BFS 的总体思路
    //      建立入度表，入度为 0 的节点先入队
    //      当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
    //      将课程的邻居入度减 1
    //      若邻居课程入度为 0，加入队列
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new LinkedList<>();
        List<Set<Integer>> map = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            int end = prerequisite[0];
            int start = prerequisite[1];
            map.get(end).add(start);
        }

        List<Integer> zeroInput = findZeroInput(map);
        Queue<Integer> queue = new LinkedList<>(zeroInput);
        Set<Integer> set = new HashSet<>(zeroInput);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pop = queue.poll();
                res.add(pop);
                flushAdjoin(map, pop);
                zeroInput = findZeroInput(map);
                for (Integer input : zeroInput) {
                    if (!set.contains(input)) {
                        queue.add(input);
                        set.add(input);
                    }
                }
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }


    private List<Integer> findZeroInput(List<Set<Integer>> map) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).size() == 0) {
                res.add(i);
            }
        }
        return res;
    }

    private void flushAdjoin(List<Set<Integer>> map, int num) {
        for (Set<Integer> set : map) {
            set.remove(Integer.valueOf(num));
        }
    }

    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2, new int[][]{{1, 0}});
    }

}
