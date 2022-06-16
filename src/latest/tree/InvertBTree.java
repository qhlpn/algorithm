package latest.tree;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertBTree {

    public TreeNode invertTree(TreeNode root) {
        doInvert(root);
        return root;
    }

    private void doInvert(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        doInvert(node.left);
        doInvert(node.right);
    }

}
