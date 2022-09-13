package bak.offer;

// 请实现一个函数，用来判断一颗二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

public class _28_SymmetricalBTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 == null || pRoot2 == null) return false;
        if (pRoot1.val != pRoot2.val) return false;
        return isSymmetrical(pRoot1.left, pRoot2.right)
                && isSymmetrical(pRoot1.right, pRoot2.left);
    }


    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(address.replaceAll("\\.", "[.]"));
//        String[] splits = address.split("\\.");
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i < splits.length; ++i) {
//            sb.append(splits[i]);
//            if(i < splits.length - 1) {
//                sb.append("[.]");
//            }
//        }
    }
}
