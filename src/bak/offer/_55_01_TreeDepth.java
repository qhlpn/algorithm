package bak.offer;

// 输入一棵二叉树，求该树的深度。

// 树的套路
// 搭出框架  if null return ;
//          左子树（从函数作用来分析） 左节点（从函数过程来分析，参数） ;
//          右子树                 右节点 ;

public class _55_01_TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 函数：树的深度
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        // 左子树 的深度
        int left = TreeDepth(root.left);
        // 右子树 的深度
        int right = TreeDepth(root.right);
        // 函数作用：计算树的深度，故返回树的深度（根据左右子树）
        return (left > right) ? left + 1 : right + 1;
    }
}
