package bak.offer;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8} 和 中序遍历序列{4,7,2,1,5,3,8,6}，
// 则重建二叉树并返回。

public class _07_ConstructBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    ////////////////////////////////////////////////////////////////////
    // 二叉树的递归套路(牢记 左子树 、 右子树 两个关键字)：
    // 左子树 + 右子树 --> 左左子树 + 左右子树   右左子树 + 右右子树 --> *** 到最低层 （递归最深处）
    // 本题旨在找出每颗 左子树 右子树 的前序和中序序列，进行递归操作

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        int i = 0;
        for (; i < in.length; i++) {
            if (pre[0] == in[i]) break;
        }
        int[] leftPre = new int[i];
        int[] leftIn = new int[i];
        for (int j = 0; j < i; j++) {
            leftPre[j] = pre[j + 1];
            leftIn[j] = in[j];
        }
        int[] rightPre = new int[in.length - 1 - i];
        int[] rightIn = new int[in.length - 1 - i];
        for (int j = 0; j < (in.length - 1 - i); j++) {
            rightPre[j] = pre[i + 1 + j];
            rightIn[j] = in[i + 1 + j];
        }
        TreeNode leftHead = reConstructBinaryTree(leftPre, leftIn);
        TreeNode rightHead = reConstructBinaryTree(rightPre, rightIn);
        TreeNode head = new TreeNode(pre[0]);
        head.left = leftHead;
        head.right = rightHead;
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode head = reConstructBinaryTree(pre, in);
    }
}
