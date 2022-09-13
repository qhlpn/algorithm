package bak.offer;

// 之字形打印二叉树

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _32_03_PrintTreesInZigzag {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void printTreesInZigzag(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<TreeNode> stack = new Stack<>();
        int thisLine = 1;
        int nextLine = 0;
        int temp = 0;
        int line = 1;
        while (!queue.isEmpty()) {
            TreeNode node = ((LinkedList<TreeNode>) queue).pop();
            thisLine--;
            if (line % 2 == 1) {
                System.out.print(node.val + "\t");
            } else {
                stack.push(node);
                if (thisLine == 0) {
                    while (!stack.isEmpty())
                        System.out.print(stack.pop().val + "\t");
                }
            }
            if (node.left != null) {
                queue.add(node.left);
                nextLine++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLine++;

            }
            if (thisLine == 0) {
                System.out.println();
                temp = nextLine;
                nextLine = 0;
                thisLine = temp;
                line++;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        printTreesInZigzag(t1);
    }
}
