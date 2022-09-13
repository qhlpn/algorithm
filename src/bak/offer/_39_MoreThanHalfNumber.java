package bak.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，
// 因此输出2。如果不存在则输出0。
public class _39_MoreThanHalfNumber {

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]) + 1;
                map.put(array[i], count);
            }
        }
        Set<Integer> set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            int num = (Integer) it.next();
            if (map.get(num) > (array.length >> 1)) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
