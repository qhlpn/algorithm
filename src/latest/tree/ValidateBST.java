package latest.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *      节点的左子树只包含 小于 当前节点的数。
 *      节点的右子树只包含 大于 当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBST {


    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        doInorderTraversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
    }

    private void doInorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        doInorderTraversal(node.left, list);
        list.add(node.val);
        doInorderTraversal(node.right, list);
    }


}
