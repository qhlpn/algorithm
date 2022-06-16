package latest.bfs;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？ 如果可以，返回 true ；否则，返回 false 。
 */
public class CourseSchedule {

    // 每次选入度为 0 的课，扣除依赖，下一轮再接着选入度为 0 的课

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> dict = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dict.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int head = prerequisites[i][1];
            int after = prerequisites[i][0];
            dict.get(after).add(head);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (dict.get(i).isEmpty()) {
                queue.add(i);
                set.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                int poll = queue.poll();
                for (int i1 = 0; i1 < numCourses; i1++) {
                    dict.get(i1).remove(poll);
                }
            }
            for (int i = 0; i < numCourses; i++) {
                if (!set.contains(i) && dict.get(i).isEmpty()) {
                    queue.add(i);
                    set.add(i);
                }
            }
        }

        return set.size() == numCourses;
    }

    public static void main(String[] args) {
        new CourseSchedule().canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}});
    }

}
