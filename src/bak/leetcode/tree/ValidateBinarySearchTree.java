package bak.leetcode.tree;

import java.util.*;


/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * @author QiuHongLong
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        inOrderScan(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> list = new ArrayList<>();

    private void inOrderScan(TreeNode node) {
        if (node == null) return;
        inOrderScan(node.left);
        list.add(node.val);
        inOrderScan(node.right);
    }


}
