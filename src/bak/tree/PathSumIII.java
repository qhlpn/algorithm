package bak.tree;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author QiuHongLong
 */
public class PathSumIII {

    private int total = 0;
    private int targetSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        doTraverse(root);
        return this.total;
    }

    private void doTraverse(TreeNode node) {
        if (node == null) return;
        doFindPath(node, new int[]{0});
        doTraverse(node.left);
        doTraverse(node.right);
    }

    private void doFindPath(TreeNode node, int[] state) {
        if (node == null) return;
        state[0] += node.val;
        if (state[0] == targetSum) total++;
        doFindPath(node.left, state);
        doFindPath(node.right, state);
        state[0] -= node.val;
    }

}
