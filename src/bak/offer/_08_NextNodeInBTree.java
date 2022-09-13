package bak.offer;

// ����һ�������������е�һ����㣬
// ���ҳ��������˳�����һ����㣨��̽ڵ㣬רָ���򣩲��ҷ��ء�
// ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
public class _08_NextNodeInBTree {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;  //ָ�򸸽ڵ�

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    ////////////////////////////////////////////////////////////////////
    // �ڵ� x ��������������������������ڵ� p �Ǻ�̽ڵ�
    //       ��û���������� x ���� ���ڵ� q ͬʱ����
    //                 (ֱ�� x �� q ����ڵ㣬һ��ʼ�������������ݣ���Ҫ�ж� q != null)��
    //                 �� q �Ǻ�̽ڵ�
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
