package bak.offer;

// ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
// ���������ǰ���������������Ľ���ж������ظ������֡�
// ��������ǰ���������{1,2,4,7,3,5,6,8} �� �����������{4,7,2,1,5,3,8,6}��
// ���ؽ������������ء�

public class _07_ConstructBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    ////////////////////////////////////////////////////////////////////
    // �������ĵݹ���·(�μ� ������ �� ������ �����ؼ���)��
    // ������ + ������ --> �������� + ��������   �������� + �������� --> *** ����Ͳ� ���ݹ������
    // ����ּ���ҳ�ÿ�� ������ ������ ��ǰ����������У����еݹ����

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        int i = 0;
        for (; i < in.length; i++) {
            if (pre[0] == in[i]) break;
        }
        int[] leftPre = new int[i];
        int[] leftIn = new int[i];
        for (int j = 0; j < i; j++) {
            leftPre[j] = pre[j + 1];
            leftIn[j] = in[j];
        }
        int[] rightPre = new int[in.length - 1 - i];
        int[] rightIn = new int[in.length - 1 - i];
        for (int j = 0; j < (in.length - 1 - i); j++) {
            rightPre[j] = pre[i + 1 + j];
            rightIn[j] = in[i + 1 + j];
        }
        TreeNode leftHead = reConstructBinaryTree(leftPre, leftIn);
        TreeNode rightHead = reConstructBinaryTree(rightPre, rightIn);
        TreeNode head = new TreeNode(pre[0]);
        head.left = leftHead;
        head.right = rightHead;
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode head = reConstructBinaryTree(pre, in);
    }
}
