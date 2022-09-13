package bak.offer;

// ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�� ��%20����
// ���磬���ַ���Ϊ We Are Happy.
// �򾭹��滻֮����ַ���Ϊ We%20Are%20Happy��

public class _05_ReplaceSpaces {
    ////////////////////////////////////////////////////////////////////
    // 1����ԭ�����ַ����ϣ����� --> �ƶ���
    // ��ǰ����
    // �����ַ���������n������ÿ���ո��ַ�����Ҫ�ƶ�����O(n)���ַ���
    // ��˶��ں���O(n)���ո��ַ����ַ�������
    // ʱ��O(n2) �ռ�O(1)

    ////////////////////////////////////////////////////////////////////
    // 2���ø������ַ������滻
    // ʱ�� O(n) �ռ� O(n)

    ////////////////////////////////////////////////////////////////////
    // 3����ԭ�����ַ����ϣ����� --> �ƶ���
    // �Ӻ���ǰ ��ָ������
    // ���е��ַ����ֻ�踴�ƣ��ƶ���һ��
    // ʱ��O(n) �ռ�O(1)
    // Java֪ʶ��: char[](����̶�����) ��String(����)
    //            StringBuffer(�������̰߳�ȫ) ��StringBuilder(�������̲߳���ȫ)
    //            �������ǰ���ͷ��������β
    public static String replaceBlank(StringBuffer str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') num++;
        }
        int pre = str.length() - 1;
        for (; num > 0; num--) {
            str.append("  ");
        }
        int pos = str.length() - 1;
        while (pre < pos) {
            if (str.charAt(pre) == ' ') {
                str.replace(pos - 2, pos + 1, "%20");
                pos = pos - 3;
                pre--;
            } else {
                str.replace(pos, pos + 1, str.substring(pre, pre + 1));
                pos--;
                pre--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Happy New Year!");
        System.out.println(sb);
        System.out.println(replaceBlank(sb));
    }
}
