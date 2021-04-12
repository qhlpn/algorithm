package leetcode.tree;

/**
 * 从先序与中序遍历序列构造二叉树
 *
 * @author QiuHongLong
 */
public class ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int preStarIdx, int preEndIdx, int[] inorder, int inStartIdx, int inEndIdx) {
        if (preStarIdx > preEndIdx) return null;
        TreeNode node = new TreeNode(preorder[preStarIdx]);
        int inSplitIdx = -1;
        for (int i = inStartIdx; i <= inEndIdx; i++) {
            if (inorder[i] == preorder[preStarIdx]) {
                inSplitIdx = i;
                break;
            }
        }
        int leftSize = inSplitIdx - inStartIdx;
        int rightSize = inEndIdx - inSplitIdx;
        node.left = doBuildTree(preorder, preStarIdx + 1, preStarIdx + leftSize, inorder, inStartIdx, inSplitIdx - 1);
        node.right = doBuildTree(preorder, preEndIdx + 1 - rightSize, preEndIdx, inorder, inSplitIdx + 1, inEndIdx);
        return node;

    }

    public static void main(String[] args) {
        // 1 2 4 3 5
        // 2 4 1 5 3
        TreeNode root = new ConstructBinaryTree().buildTree(new int[]{1, 2, 4, 3, 5}, new int[]{2, 4, 1, 5, 3});
        System.out.println();
    }


}
