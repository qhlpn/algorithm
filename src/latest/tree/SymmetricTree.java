package latest.tree;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return onSymmetrics(root, root);
    }

    private boolean onSymmetrics(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return onSymmetrics(n1.left, n2.right)
                && onSymmetrics(n1.right, n2.left);
    }

}
