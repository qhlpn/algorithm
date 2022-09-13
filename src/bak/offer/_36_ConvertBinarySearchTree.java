package bak.offer;

// 输入一棵二叉搜索树，
// 将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。

import java.util.ArrayList;

public class _36_ConvertBinarySearchTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        ArrayList<TreeNode> al = new ArrayList<>();
        ConvertRecur(pRootOfTree, al);
        while (pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }

    public static void ConvertRecur(TreeNode node, ArrayList<TreeNode> al) {
        if (node == null) return;
        ConvertRecur(node.left, al);
        al.add(node);
        if (al.size() == 2) {
            TreeNode pre = al.get(0);
            TreeNode pos = al.get(1);
            pre.right = pos;
            pos.left = pre;
            al.clear();
            al.add(pos);
        }
        ConvertRecur(node.right, al);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(14);
        t1.left = t2;
        t2.right = t3;
        t1.right = t4;
        TreeNode node = Convert(t1);
        System.out.println();

    }
}
