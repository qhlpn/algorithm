package latest.tree;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return doMergeTrees(root1, root2);
    }


    public TreeNode doMergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return null;
        int val1 = 0;
        TreeNode n1Le = null;
        TreeNode n1Rt = null;
        if (node1 != null) {
            val1 = node1.val;
            n1Le = node1.left;
            n1Rt = node1.right;
        }
        int val2 = 0;
        TreeNode n2Le = null;
        TreeNode n2Rt = null;
        if (node2 != null) {
            val2 = node2.val;
            n2Le = node2.left;
            n2Rt = node2.right;
        }

        TreeNode node = new TreeNode(val1 + val2);
        node.left = doMergeTrees(n1Le, n2Le);
        node.right = doMergeTrees(n1Rt, n2Rt);
        return node;
    }


}
