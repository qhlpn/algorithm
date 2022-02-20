package bak.leetcode.tree;

import java.util.ArrayList;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * @author QiuHongLong
 */
public class RecoverBinarySearchTree {

    ArrayList<TreeNode> nodes = new ArrayList<>();

    public void recoverTree(TreeNode root) {

        // 二叉搜索树，中序遍历递增
        inOrderTree(root);
        int leftIdx = 0;
        int rightIdx = nodes.size() - 1;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                leftIdx = i;
                break;
            }
        }
        for (int i = nodes.size() - 1; i > 0; i--) {
            if (nodes.get(i).val < nodes.get(i - 1).val) {
                rightIdx = i;
                break;
            }
        }
        int temp = nodes.get(leftIdx).val;
        nodes.get(leftIdx).val = nodes.get(rightIdx).val;
        nodes.get(rightIdx).val = temp;
    }


    private void inOrderTree(TreeNode node) {
        if (node == null) return;
        inOrderTree(node.left);
        nodes.add(node);
        inOrderTree(node.right);
    }



}
