package bak.offer;

// 输入两棵二叉树A，B，判断B是不是A的子结构。
// ps：我们约定空树不是任意一个树的子结构

public class _26_SubstructureInTree {

    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                flag = DoesTree1HaveTree2(root1, root2);
            if (!flag)
                flag = HasSubtree(root1.left, root2)
                        || HasSubtree(root1.right, root2);
        }
        return flag;
    }

    public static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left)
                && DoesTree1HaveTree2(root1.right, root2.right);
    }


    public static boolean flag = false;

    // 功能：每个节点执行matchSubTree函数
    public static void preOrder(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        if (flag != true) {
            flag = matchSubTree(root1, root2);
        }
        preOrder(root1.left, root2);
        preOrder(root1.right, root2);
    }

    public static boolean matchSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return matchSubTree(root1.left, root2.left) && matchSubTree(root1.right, root2.right);
    }


    public static void main(String[] args) {
        TreeNode h1 = new TreeNode(1);
        TreeNode h2 = new TreeNode(2);
        TreeNode h3 = new TreeNode(3);
        h1.left = h2;
        h2.left = h3;
        TreeNode w2 = new TreeNode(2);
        TreeNode w3 = new TreeNode(3);
        w2.left = w3;
        preOrder(h1, w2);
        System.out.println(HasSubtree(h1, w2));
    }
}
