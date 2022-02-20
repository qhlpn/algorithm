package bak.decide;

import bak.tree.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class PathSumII {


    private int targetSum;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        doFindPath(root, new ArrayList<>(), 0);
        return result;
    }

    private void doFindPath(TreeNode node, List<Integer> currentPath, int currentSum) {
        if (node == null) return;
        int num = node.val;
        currentPath.add(num);
        currentSum += num;
        if (node.left == null && node.right == null
                && currentSum == targetSum) result.add(new ArrayList<>(currentPath));
        doFindPath(node.left, currentPath, currentSum);
        doFindPath(node.right, currentPath, currentSum);
        currentPath.remove(currentPath.size() - 1);

    }


}
