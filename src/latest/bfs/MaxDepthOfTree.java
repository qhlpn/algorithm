package latest.bfs;

import latest.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepthOfTree {

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        if (root != null){ queue.add(root);}
        while (!queue.isEmpty()) {
            level++;
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode pop = queue.poll();
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
        }
        return level;
    }

}
