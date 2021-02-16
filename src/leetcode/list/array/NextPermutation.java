package leetcode.list.array;

/**
 * 将给定数字序列重新排列成字典序中下一个更大的排列
 * @author QiuHongLong
 */
public class NextPermutation {


    public void nextPermutation(int[] nums) {
        // 最近的 + 最小的 + 重新排序

        int index = -1;
        // 从低位到高位 定位到 最近的 比自己小的 高位数的下标
        for (int i = nums.length - 1; i >= 0; i--) {
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            // 找出 低位的大数中的 最小值
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (nums[j] < minVal) {
                        minIdx = j;
                        minVal = nums[j];
                    }
                }
            }
            if (minIdx != -1) {
                swap(nums, minIdx, i);
                index = i;
                break;
            }
        }
        // 低位重新排序
        for (int i = index + 1; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }

    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 3, 2});
    }

}


//  1234
//  3214
//  3241
//  1234
//  1244