package leetcode.list.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author QiuHongLong
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int cursor = 0;
        int flow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[flow] != 0) {
                nums[cursor++] = nums[flow];
            }
            flow++;
        }

        for (int i = cursor; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

}
