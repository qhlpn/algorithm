package bak.offer;

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _32_01_PrintTreeFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> help = new LinkedList<>();
        ArrayList<Integer> resp = new ArrayList<>();
        help.add(root);
        while (!help.isEmpty()) {
            TreeNode pop = ((LinkedList<TreeNode>) help).pop();
            resp.add(pop.val);
            if (pop.left != null) help.add(pop.left);
            if (pop.right != null) help.add(pop.right);
        }
        return resp;
    }
}
