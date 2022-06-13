package latest.bfs;

import latest.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ress = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode pop = queue.poll();
                res.add(pop.val);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            ress.add(res);
        }
        return ress;
    }

}
