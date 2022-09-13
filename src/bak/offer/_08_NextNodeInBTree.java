package bak.offer;

// 给定一个二叉树和其中的一个结点，
// 请找出中序遍历顺序的下一个结点（后继节点，专指中序）并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class _08_NextNodeInBTree {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;  //指向父节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    ////////////////////////////////////////////////////////////////////
    // 节点 x 若有右子树，则右子树的最左节点 p 是后继节点
    //       若没右子树，则 x 与其 父节点 q 同时上溯
    //                 (直到 x 是 q 的左节点，一开始就满足则不用上溯，需要判断 q != null)，
    //                 则 q 是后继节点
    // Debug: TreeLinkNode p = null;
    //        System.out.println(p.next);
    //        Exception in thread "main" java.lang.NullPointerException
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return getMostLeft(pNode.right);
        } else {
            TreeLinkNode q = pNode.next;
            while (q != null && pNode != q.left) {
                pNode = q;
                q = q.next;
            }
            return q;
        }
    }

    public static TreeLinkNode getMostLeft(TreeLinkNode pNode) {
        while (pNode.left != null) {
            pNode = pNode.left;
        }
        return pNode;
    }

}
