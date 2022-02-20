package bak.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 等同于求节点的深度
 *
 * @author QiuHongLong
 */
public class DiameterofBinaryTree {

    private int maxLength = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        postOrder(root);
        return maxLength;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        maxLength = Math.max(maxLength, left + right + 1);
        return Math.max(left, right) + 1;
    }

}
