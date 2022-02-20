package bak.tree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * @author QiuHongLong
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        doMaxDepth(root, 1);
        return maxLevel;
    }

    private int maxLevel = 0;

    private void doMaxDepth(TreeNode node, int level) {
        if (node == null) return;
        maxLevel = Math.max(maxLevel, level);
        doMaxDepth(node.left, level + 1);
        doMaxDepth(node.right, level + 1);
    }

}
