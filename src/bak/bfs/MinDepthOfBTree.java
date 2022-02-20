package bak.bfs;

import bak.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinDepthOfBTree {


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.add(root);
        set.add(root);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left == null && right == null) return step;
                if (left != null && !set.contains(left)) {
                    queue.add(left);
                    set.add(left);
                }
                if (right != null && !set.contains(right)) {
                    queue.add(right);
                    set.add(right);
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.left = n3;
        System.out.println(new MinDepthOfBTree().minDepth(n1));
    }



}
