package leetcode.bfs;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * @author QiuHongLong
 */
public class LevelTraversalOfTree {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> intss = new ArrayList<>();
        if (root == null) return intss;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ints = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                TreeNode left = pop.left;
                TreeNode right = pop.right;
                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
                ints.add(pop.val);
            }
            intss.add(ints);
        }
        return intss;

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(new LevelTraversalOfTree().levelOrder(n1));
    }

}
