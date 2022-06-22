package latest.tree;


/**
 * omg
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 */
public class TreeMaxPathSum {

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return maxSum;
    }

    private int maxSum = Integer.MIN_VALUE;

    // 后序遍历
    // 节点单边的最大路径和

    private int doMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = doMaxPathSum(node.left);
        int right = doMaxPathSum(node.right);
        int curr = node.val;
        maxSum = Math.max(left + right + curr, maxSum);
        return Math.max(Math.max(left, right) + curr, 0);
    }


}
