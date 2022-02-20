package bak.leetcode.decide;

import java.util.HashSet;
import java.util.Set;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 1. 装满任意一个水壶
 * 2. 清空任意一个水壶
 * 3. 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class WaterAndJugProblem {

    private Set<String> set = new HashSet();
    private boolean result = false;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        dfs(jug1Capacity, jug2Capacity, 0, 0, targetCapacity);
        return result;
    }


    public void dfs(int jug1Cap, int jug2Cap, int jug1Usage, int jug2Usage, int targetCap) {
        if (!result) {
            String tag = jug1Usage + "@" + jug2Usage;
            if (set.contains(tag)) return;
            set.add(jug1Usage + "@" + jug2Usage);
            if (jug1Usage + jug2Usage == targetCap) result = true;

            // 清空 1
            dfs(jug1Cap, jug2Cap, 0, jug2Usage, targetCap);

            // 清空 2
            dfs(jug1Cap, jug2Cap, jug1Usage, 0, targetCap);

            // 装满 1
            dfs(jug1Cap, jug2Cap, jug1Cap, jug2Usage, targetCap);

            // 装满 2
            dfs(jug1Cap, jug2Cap, jug1Usage, jug2Cap, targetCap);

            // 1 倒 2
            int jug1Next = Math.max(0, jug1Usage - (jug2Cap - jug2Usage));
            int jug2Next = Math.min(jug2Cap, jug2Usage + jug1Usage);
            dfs(jug1Cap, jug2Cap, jug1Next, jug2Next, targetCap);

            // 2 倒 1
            jug1Next = Math.min(jug1Cap, jug1Usage + jug2Usage);
            jug2Next = Math.max(0, jug2Usage - (jug1Cap - jug1Usage));
            dfs(jug1Cap, jug2Cap, jug1Next, jug2Next, targetCap);

        }
    }

    public static void main(String[] args) {
        new WaterAndJugProblem().canMeasureWater(3, 5, 4);
    }


}
