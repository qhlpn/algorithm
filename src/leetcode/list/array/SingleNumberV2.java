package leetcode.list.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * @author QiuHongLong
 */
public class SingleNumberV2 {

    public int singleNumber(int[] nums) {

        int[] bits = new int[32];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += ((nums[i] >> j) & 1);
                bits[j] %= 3;
            }
        }

        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            result += (bits[i] << i);
        }

        return result;

    }


    public static void main(String[] args) {
        new SingleNumberV2().singleNumber(new int[]{2, 3, 2, 2});
    }

}
