package bak.leetcode.decide;

import leetcode.tree.TreeNode;

import java.util.stream.Stream;

/**
 * 聪明的小偷意识到这个地方的所有房屋的排列类似于一棵二叉树。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 不能用 dfs 做，因为不是 一条路 从根节点到 某个 子节点
 * 而是 多条路 从根节点到 多个 子节点
 * 用 树的 后序遍历，找 左右子树 的某个属性
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    private int[] postOrder(TreeNode node) {

        if (node == null)
            return new int[]{0, 0};

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        // 1 不抢 2 抢
        int[] res = new int[2];

        // 当前节点不抢，子节点可抢可不抢
        res[0] = Stream.of(left[0] + right[0], left[0] + right[1], left[1] + right[0], left[1] + right[1]).max(Integer::compare).get();
        // 当前节点不抢，子节点都不能抢
        res[1] = node.val + left[0] + right[0];

        return res;


    }

    public static void main(String[] args) {


    }

}
