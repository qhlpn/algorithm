package bak.offer;

// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

public class _55_02_BalancedBinaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return false;
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    public int getHeight(TreeNode node, int height, boolean[] res) {
        if (node == null) return height;
        int left = getHeight(node.left, height + 1, res);
        int right = getHeight(node.right, height + 1, res);
        if (Math.abs(left - right) > 1) res[0] = false;
        return Math.max(left, right);
    }
}
