package latest.bfs;

import javafx.util.Pair;

import java.nio.file.Path;
import java.util.*;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 */
public class EvaluateDivision {


    private List<List<String>> equations = null;
    private double[] values = null;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.equations = equations;
        this.values = values;
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            List<Pair<Integer, Integer>> tmpPath = new LinkedList<>();
            List<Pair<Integer, Integer>> realPath = new LinkedList<>();
            doFindPath(src, dest, tmpPath, new HashSet<>(), realPath);
            if (realPath.isEmpty()) ret[i] = -1.0;
            else ret[i] = doCalculate(realPath);
        }
        return ret;
    }

    private double doCalculate(List<Pair<Integer, Integer>> realPath) {
        double ret = 1.0;
        for (int i = 0; i < realPath.size(); i++) {
            Pair<Integer, Integer> pair = realPath.get(i);
            int idx = pair.getKey();
            int order = pair.getValue();
            if (idx == -1) return 1.0;
            if (order == 0) {
                ret = ret * values[idx];
            } else if (order == 1) {
                ret = ret / values[idx];
            }
        }
        return ret;
    }


    private void doFindPath(String curr, String dest, List<Pair<Integer, Integer>> path, Set<Integer> memo, List<Pair<Integer, Integer>> ret) {
        if (curr.equals(dest)) {
            if (path.isEmpty()) {
                for (int i = 0; i < equations.size(); i++) {
                    if (curr.equals(equations.get(i).get(0))
                            || dest.equals(equations.get(i).get(1))) {
                        path.add(new Pair<>(-1, 0));
                    }
                }
            }
            if (ret.isEmpty()) {
                ret.addAll(path);
            }
            return;
        }
        List<Pair<Integer, Integer>> chooses = new LinkedList<>();
        for (int i = 0; i < equations.size(); i++) {
            if (!memo.contains(i)) {
                if (curr.equals(equations.get(i).get(0)))
                    chooses.add(new Pair<>(i, 0));
                if (curr.equals(equations.get(i).get(1)))
                    chooses.add(new Pair<>(i, 1));
            }
        }
        for (int i = 0; i < chooses.size(); i++) {
            Pair<Integer, Integer> pair = chooses.get(i);
            int idx = pair.getKey();
            int order = pair.getValue();
            path.add(pair);
            memo.add(idx);
            String next = equations.get(idx).get(1 - order);
            doFindPath(next, dest, path, memo, ret);
            path.remove(pair);
            memo.remove(idx);
        }
    }


    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        List<String> e1 = new LinkedList<String>() {{
            add("a"); add("b");
        }};
        List<String> e2 = new LinkedList<String>() {{
            add("b"); add("c");
        }};
        equations.add(e1);
        equations.add(e2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new LinkedList<>();
        List<String> q1 = new LinkedList<String>(){{
            add("a"); add("a");
        }};
        queries.add(q1);
        new EvaluateDivision().calcEquation(equations, values, queries);
    }

}
