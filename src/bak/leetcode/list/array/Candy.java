package bak.leetcode.list.array;

/**
 * 每个孩子至少分配到 1 个糖果
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果
 * @author QiuHongLong
 */
public class Candy {

    public int candy(int[] ratings) {

        int[] children = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] && children[i] <= children[i - 1]) {
                children[i] = children[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1] && children[i] <= children[i + 1]) {
                children[i] = children[i + 1] + 1;
            }
        }

        int total = children.length;
        for (int i = 0; i < children.length; i++) {
            total += children[i];
        }

        return total;

    }

    public static void main(String[] args) {
        new Candy().candy(new int[]{1, 3, 4, 5, 2});
    }

}
