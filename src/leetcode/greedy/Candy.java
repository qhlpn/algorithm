package leetcode.greedy;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 1. 每个孩子至少分配到 1 个糖果。
 * 2. 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * @author QiuHongLong
 */
public class Candy {

    public int candy(int[] ratings) {

        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];

        leftToRight[0] = 0;
        for (int i = 1; i < ratings.length; i++) {
            leftToRight[i] = ratings[i] > ratings[i - 1] ? leftToRight[i - 1] + 1 : 0;
        }

        rightToLeft[rightToLeft.length - 1] = 0;
        for (int i = rightToLeft.length - 2; i >= 0; i--) {
            rightToLeft[i] = ratings[i] > ratings[i + 1] ? rightToLeft[i + 1] + 1 : 0;
        }

        int total = ratings.length;
        for (int i = 0; i < ratings.length; i++) {
            total += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return total;

    }

    public static void main(String[] args) {
        new Candy().candy(new int[]{1, 2, 87, 87, 87, 2, 1});
    }
}
