package leetcode.tree;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 *
 * @author QiuHongLong
 */
public class BinaryTreeMaxPathSum {

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return maxPathSum;
    }

    private int maxPathSum = Integer.MIN_VALUE;

    /**
     * 后序遍历
     */
    private int doMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(doMaxPathSum(node.left), 0);
        int right = Math.max(doMaxPathSum(node.right), 0);
        int curr = node.val;
        maxPathSum = Math.max(left + right + curr, maxPathSum);
        return Math.max(left, right) + curr;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        new BinaryTreeMaxPathSum().maxPathSum(n1);
    }


}
