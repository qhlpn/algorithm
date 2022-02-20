package bak.leetcode.bfs;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @author QiuHongLong
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //  拓扑序列（有向图、入度、出度）
        //  [0,1] (1 -> 0)
        //  每次只能选入度为 0 的课，因为它不依赖别的课，是当下你能上的课。
        //  假设选了 0，课 3 的先修课少了一门，入度由 2 变 1。
        //  接着选 1，导致课 3 的入度变 0，课 4 的入度由 2 变 1。
        //  接着选 2，导致课 4 的入度变 0。
        //  现在，课 3 和课 4 的入度为 0。继续选入度为 0 的课……直到选不到入度为 0 的课。

        Map<Integer, List<Integer>> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inMap.put(i, new ArrayList<>());
            outMap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inMap.get(prerequisite[0]).add(prerequisite[1]);
            outMap.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        inMap.forEach((k, v) -> {
            if (v.isEmpty() && !set.contains(k)) {
                queue.add(k);
                set.add(k);
            }
        });
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer course = queue.poll();
                for (Integer integer : outMap.get(course)) {
                    inMap.get(integer).remove(course);
                }
            }
            inMap.forEach((k, v) -> {
                if (v.isEmpty() && !set.contains(k)) {
                    queue.add(k);
                    set.add(k);
                }
            });
        }

        for (Map.Entry<Integer, List<Integer>> entry : inMap.entrySet()) {
            if (!entry.getValue().isEmpty()) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean bool = new CourseSchedule().canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        System.out.println();
    }

}
