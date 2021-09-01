package leetcode.greedy;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * @author QiuHongLong
 */
public class QueueReconstructByHeight {


    public int[][] reconstructQueue(int[][] people) {




//        排序完的people：
//        [[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
//
//        插入的过程：
//        插入[7,0]：[[7,0]]
//        插入[7,1]：[[7,0],[7,1]]
//        插入[6,1]：[[7,0],[6,1],[7,1]]
//        插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
//        插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
//        插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        List<List<Integer>> arrays = new ArrayList<>();
        for (int[] person : people) {
            arrays.add(Arrays.asList(person[0], person[1]));
        }
        arrays.sort((l, r) -> {
            if (!l.get(0).equals(r.get(0))) {
                return r.get(0) - l.get(0);
            } else {
                return l.get(1) - r.get(1);
            }
        });

        List<List<Integer>> insert = new LinkedList<>();
        for (List<Integer> array : arrays) {
            insert.add(array.get(1), array);
        }

        int[][] result = new int[insert.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = insert.get(i).get(0);
            result[i][1] = insert.get(i).get(1);
        }

        return result;

    }

    public static void main(String[] args) {
        new QueueReconstructByHeight().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
    }


}
