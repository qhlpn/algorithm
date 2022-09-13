package bak.offer;

// 输入一颗二叉树的跟节点和一个整数，
// 打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
// (注意: 在返回值的list中，数组长度大的数组靠前)

import java.util.ArrayList;

public class _34_PathInTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return new ArrayList();
        ArrayList<ArrayList<Integer>> al = new ArrayList();
        ArrayList<Integer> path = new ArrayList<>();
//        path.add(root.val);
        int[] sum = new int[1];
        process(root, target, sum, al, path);
//        FindPath(root, target, root.val, al, path);
        if (al.size() < 2) return al;
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.size() - 1 - i; j++) {
                if (al.get(j).size() < al.get(j + 1).size()) {
                    ArrayList<Integer> help = al.get(j);
                    al.set(j, al.get(j + 1));
                    al.set(j + 1, help);
                }

            }
        }
        return al;
    }

    public static void FindPath(TreeNode root, int target, int sum, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> path) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ArrayList<Integer> newPath = (ArrayList<Integer>) path.clone();
                al.add(newPath);
            }
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            FindPath(root.left, target, sum + root.left.val, al, path);
        }
        if (root.right != null) {
            path.add(root.right.val);
            FindPath(root.right, target, sum + root.right.val, al, path);
        }
        path.remove(path.size() - 1);
        return;
    }

    public static void process(TreeNode root, int target, int[] sum, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum[0] += root.val;
        if (target == sum[0]) {
            ArrayList<Integer> clone = new ArrayList<>();
            path.forEach(n ->
                    clone.add(n));
            al.add(clone);
        }
        process(root.left, target, sum, al, path);
        process(root.right, target, sum, al, path);
        path.remove((Integer) root.val);
        sum[0] -= root.val;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        ArrayList<ArrayList<Integer>> al = FindPath(t1, 22);
        System.out.println();
    }
}
