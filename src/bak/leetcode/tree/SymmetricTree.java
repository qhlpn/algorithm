package bak.leetcode.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author QiuHongLong
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root.left, root.right);
    }

    /**
     * 正向遍历和镜像遍历同时进行
     */
    private boolean doIsSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val
                && doIsSymmetric(n1.left, n2.right)
                && doIsSymmetric(n1.right, n2.left);
    }
}
