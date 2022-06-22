package latest.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * omg
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class FlattenTreeToList {

    private List<TreeNode> list = new LinkedList<>();
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public void flatten(TreeNode root) {
        doPreOrderTraveral(root);
        TreeNode node;
        TreeNode curr;
        TreeNode next;
        for (int i = 0; i < list.size() - 1; i++) {
            node = list.get(i);
            curr = map.get(node);
            next = map.get(list.get(i + 1));
            curr.right = next;
        }

    }

    private void doPreOrderTraveral(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = new TreeNode(node.val);
        list.add(tmp);
        map.put(tmp, node);
        doPreOrderTraveral(node.left);
        doPreOrderTraveral(node.right);
        node.left = null;
        node.right = null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        new FlattenTreeToList().flatten(n1);

    }

}
