package bak.offer;

// 从扑克牌中随机抽取5张牌
// 判断是不是一个顺子

import java.util.Arrays;

public class _61_ContinousCards {

    // 思路：
    // 排序 --> 统计0的个数 -->
    // 判断非0得数字中有无等值 -->
    // 统计排序数组中相邻数字间的空格数

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5)
            return false;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] < 0 || numbers[i] > 13)
                return false;
        Arrays.sort(numbers);
        int numOfZero = 0;
        int numOfGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
            } else {
                while (i + 1 < numbers.length) {
                    numOfGap += numbers[i + 1] - numbers[i] - 1;
                    i++;
                }
                break;
            }
        }
        if (numOfZero == 4 || numOfGap == numOfZero)
            return true;
        return false;
    }
}
