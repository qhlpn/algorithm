package bak.offer;

// �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
// ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
// ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ�
// ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ��� "bcced" ��·����
// ���Ǿ����в����� "abcb" ·����
// ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�

public class _12_StringPathInMatrix {

    //////////////////////////////////////////////////////////
    // ˼·�����ݷ��������������DFS��һ�֣�
    //      ��ά�����˶����ⳣ�ã����Թ��ȣ�
    // ���𣺻��ݷ����������в��������������ṹ����������������������������������
    //      ���ݷ� ��ͬ ����������������ñ�־�ķ�����¼���ʹ���״̬�����ٴ洢�ռ䣩 boolean flag[]
    // ���ݷ��ؼ��� --> ��־λ�����е���������Ϣ���ռ����۱߽�
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean flag[] = new boolean[matrix.length];
        // �� ����ÿ������Ϊ��� ���г���
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    // k��ƥ�䵽��str[k]
    // flag����־λ����¼���ʹ��ľ����  ��ֹ���η���
    //      ����¼����·���еĲ��� true ����ָOffer P88 �����ˣ�
    //      str{a,e,g,h,u} ����·����str {a,e,g,-->}  ��ʱֻ�� a��e��g��true�����ܵĵ㲻��
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag) {
        // ������ת�� --> һά����ģ���ά����
        int index = i * cols + j;
        // ===== ���жϵ�ǰ���Ƿ�����Ҫ�� =========

        // ===== ��ǰ�㲻����Ҫ�������� =====
        // ����Խ�� (i < 0 || i >= rows || j < 0 || j >= cols��
        // ·���ϵĵ���Ŀ�겻��� (matrix[index] != str[k])
        // �Ѿ����ʹ������ϵĴ˵� (flag[index])  �����
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) return false;

        // ===== ��ǰ������Ҫ�������� =======
        // �ж��Ƿ��Ѿ�ƥ��Ŀ��·�����е��ַ�
        if (k == str.length - 1) return true;
        // ��־λ��¼���ʹ��ľ����(��ǰ��)
        flag[index] = true;
        // �� ��ǰ�� ��Χ�ĸ��������һ������
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) return true;
        // ��ǰ�� ��Χ�ĸ���ûһ������ �����ݵ�ǰ����ϸ���
        // ��ǰ���־λ���
        flag[index] = false;
        return false;
    }


    public boolean process() {

        return true;
    }








}
