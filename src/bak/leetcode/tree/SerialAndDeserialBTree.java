package bak.leetcode.tree;

/**
 * 二叉树序列化和反序列化
 *
 * @author QiuHongLong
 */
public class SerialAndDeserialBTree {

    private final StringBuilder serial = new StringBuilder();

    public String serialize(TreeNode root) {
        if (root == null) return "";
        doSerialize(root);
        return serial.substring(0, serial.length() - 1);
    }

    private void doSerialize(TreeNode node) {
        if (node == null) {
            serial.append("#,");
            return;
        }
        serial.append(node.val).append(",");
        doSerialize(node.left);
        doSerialize(node.right);
    }


    private int idx = 0;

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) return null;
        String[] ss = data.split(",");
        TreeNode root = doDeserialize(ss);
        return root;
    }

    private TreeNode doDeserialize(String[] ss) {
        if (ss.length == idx || "#".equals(ss[idx])) return null;
        TreeNode node = new TreeNode(Integer.parseInt(ss[idx]));
        idx++;
        node.left = doDeserialize(ss);
        idx++;
        node.right = doDeserialize(ss);
        return node;
    }

    public static void main(String[] args) {
        SerialAndDeserialBTree o = new SerialAndDeserialBTree();
        String s = o.serialize(o.deserialize("1,2,#,#,3,4,#,#,5,#,#"));
        System.out.println();
    }


}
