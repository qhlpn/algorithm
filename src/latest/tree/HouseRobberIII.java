package latest.tree;

import java.util.stream.Stream;

/**
 * omg
 * 聪明的小偷意识到这个地方的所有房屋的排列类似于一棵二叉树。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] ret = dorob(root);
        return Math.max(ret[0], ret[1]);
    }


    // 后序遍历
    // 节点抢和不抢时，两种情况分别的最高金额

    private int[] dorob(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dorob(node.left);
        int[] right = dorob(node.right);

        // idx 0 抢  idx 1 不抢
        int[] ret = new int[]{0, 0};

        ret[0] = left[1] + right[1] + node.val;
        ret[1] = Stream.of(left[0] + right[0], left[0] + right[1], left[1] + right[0], left[1] + right[1]).max(Integer::compare).get();
        return ret;
    }

}
