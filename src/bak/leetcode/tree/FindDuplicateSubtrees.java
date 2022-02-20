package bak.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可
 * 两棵树重复是指它们具有相同的结构以及相同的结点值
 *
 * @author QiuHongLong
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        doFindDuplicateSubtrees(root);
        return nodes;
    }

    private HashMap<String, Integer> map = new HashMap<>();
    private List<TreeNode> nodes = new LinkedList<>();

    /**
     * 用字符串标识树的唯一性
     */
    private String doFindDuplicateSubtrees(TreeNode node) {
        if (node == null) return "#";
        String left = doFindDuplicateSubtrees(node.left);
        String right = doFindDuplicateSubtrees(node.right);
        String curr = Integer.toString(node.val);
        String path = left + "," + curr + "," + right;
        if (map.containsKey(path)) {
            if (map.get(path) == 1) nodes.add(node);
            map.put(path, map.get(path) + 1);
        } else {
            map.put(path, 1);
        }
        return path;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        new FindDuplicateSubtrees().findDuplicateSubtrees(node1);
    }

}
