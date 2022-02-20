package bak.leetcode.queue;

import java.util.Arrays;

/**
 * 不同种类的任务，任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完
 * 两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态
 * 计算完成所有任务所需要的 最短时间
 *
 * @author QiuHongLong
 */
public class TaskScheduler {


    /**
     * 桶思想
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *    如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->待命->待命->A->待命->待命->A
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *    则 retCount++ ==> A->B->待命->A->B->待命->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     */
    public int leastInterval(char[] tasks, int n) {
        Integer[] bucket = new Integer[26];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < tasks.length; i++) {
            bucket[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(bucket, (l, r) -> r - l);
        int initCount = (bucket[0] - 1) * (n + 1) + 1;
        int totalCount = 0;
        totalCount += bucket[0];
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i].equals(bucket[0])) initCount += 1;
            totalCount += bucket[i];
        }
        int resCount = Math.max(initCount, totalCount);
        return resCount;
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }

}
