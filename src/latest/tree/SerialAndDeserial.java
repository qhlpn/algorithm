package latest.tree;

/**
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构
 */
public class SerialAndDeserial {

    private static final String NULL = "null";
    private static final String SPL = "#";

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    private void doSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SPL);
            return;
        }
        sb.append(node.val).append(SPL);
        doSerialize(node.left, sb);
        doSerialize(node.right, sb);
    }


    // Decodes your encoded data to tree.

    private int idx = 0;
    public TreeNode deserialize(String data) {
        String[] serial = data.split(SPL);
        return doDeserialize(serial);
    }

    public TreeNode doDeserialize(String[] serial) {
        String val = serial[idx];
        if (NULL.equals(val)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        idx++; node.left = doDeserialize(serial);
        idx++; node.right = doDeserialize(serial);
        return node;
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

    }
