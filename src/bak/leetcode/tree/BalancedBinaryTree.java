package bak.leetcode.tree;

public class BalancedBinaryTree {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        findDepth(root);
        return isBalanced;
    }

    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if (Math.abs(right-left)> 1) isBalanced = false;
        return Math.max(left, right) + 1;
    }


}
