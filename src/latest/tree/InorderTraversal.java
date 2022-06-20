package latest.tree;

import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        doInOrderTraversal(root, ret);
        return ret;
    }

    private void doInOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        doInOrderTraversal(node.left, list);
        list.add(node.val);
        doInOrderTraversal(node.right, list);
    }


}
