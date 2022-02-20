package bak.binsearch;

import bak.tree.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = sortedArrayToBST(nums, 0, nums.length - 1);
        return res;
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }


}
