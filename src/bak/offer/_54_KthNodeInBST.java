package bak.offer;

// �����������ĵ� K ��ڵ�
public class _54_KthNodeInBST {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private static int tick;
    private static TreeNode KthNode;

    // ���ô���ֻ���޸����ݣ������޸����õ�ַ���޸ĺ󴫲���ȥ�ģ�
    // main(){
    //    TreeNode node = new TreeNode(-1); --> node:@672
    //    func(node);
    //    System.out.println(node);         --> node:@672
    // }
    //
    // void func(TreeNode node){
    //    TreeNode n = new TreeNode(-1); --> n:@674
    //    node = n;   --> node:@674 (�޸ĵ�ַ�󴫲���ȥ��)
    // }

    public static TreeNode KthNodeInBST(TreeNode node, int k) {
        if (node == null) return null;
        tick = 0;
        KthNode = null;
        InOrderRecur(node, k);
        return KthNode;
    }

    public static void InOrderRecur(TreeNode node, int k) {
        if (node == null) return;
        InOrderRecur(node.left, k);
        if (++tick == k) KthNode = node;
        InOrderRecur(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(14);
        t1.left = t2;
        t2.right = t3;
        t1.right = t4;
        TreeNode node = KthNodeInBST(t1, 1);
        System.out.println();
    }
}
