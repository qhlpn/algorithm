package bak.offer;

// 分行从上到下打印二叉树

import java.util.LinkedList;
import java.util.Queue;

public class _32_02_PrintTreesInLines {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void printTreesInLines(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> help = new LinkedList<>();
        help.add(root);
        int thisLine = 1;
        int nextLine = 0;
        int temp = 0;
        while (!help.isEmpty()) {
            TreeNode node = ((LinkedList<TreeNode>) help).pop();
            thisLine--;
            System.out.print(node.val + "\t");
            if (node.left != null) {
                help.add(node.left);
                nextLine++;
            }
            if (node.right != null) {
                help.add(node.right);
                nextLine++;
            }
            if (thisLine == 0) {
                System.out.println();
                temp = nextLine;
                nextLine = 0;
                thisLine = temp;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        printTreesInLines(t1);
    }
}

