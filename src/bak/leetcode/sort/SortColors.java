package bak.leetcode.sort;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * @author QiuHongLong
 */
public class SortColors {

    public void sortColors(int[] nums) {

        // 使用桶
        int[] buckets = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                buckets[0]++;
            } else if (nums[i] == 1) {
                buckets[1]++;
            } else if (nums[i] == 2) {
                buckets[2]++;
            }
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            int cnt = buckets[i];
            for (int j = 0; j < cnt; j++) {
                nums[index++] = i;
            }
        }

    }

}
