package bak.offer;

// ����һ�ö����������������ȡ�

// ������·
// ������  if null return ;
//          ���������Ӻ��������������� ��ڵ㣨�Ӻ��������������������� ;
//          ������                 �ҽڵ� ;

public class _55_01_TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // �������������
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        // ������ �����
        int left = TreeDepth(root.left);
        // ������ �����
        int right = TreeDepth(root.right);
        // �������ã�����������ȣ��ʷ���������ȣ���������������
        return (left > right) ? left + 1 : right + 1;
    }
}
