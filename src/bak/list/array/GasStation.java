package bak.list.array;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1
 *
 * @author QiuHongLong
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            int total = 0;
            boolean valid = true;
            for (int j = 0; j < gas.length; j++) {
                int index = (i + j) % gas.length;
                total = total + gas[index] - cost[index];
                if (total < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return i;
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        new GasStation().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

}
