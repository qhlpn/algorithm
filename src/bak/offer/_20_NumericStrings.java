package bak.offer;

// ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
// ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
// ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�

public class _20_NumericStrings {

    //////////////////////////////////////////////////////////
    // �ⷨ1���⺯����(Ц cry)
    public boolean isNumericI(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //////////////////////////////////////////////////////////
    //�ⷨ2��������ʽ
    //    \\+  \\-  \\.  ת����ַ�  + - .
    //    [ ]   �����е�����ȡһ��
    //    ��    �ʺ�ǰ�����������Գ���һ��
    //    *     �Ǻ�ǰ�����ݿ��Գ��������
    public boolean isNumericII(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    //////////////////////////////////////////////////////////
    //�ⷨ3����ʾ���ֵ��ַ�����ѭģʽ
    //      A[.[B]][e|EC]  .B[e|EC]
    //      ��ǰ����ɨ��
    public boolean isNumericIII(char[] str) {
        if (str == null || str.length == 0) return false;
        int[] index = {0};
        // 1�����Ⱦ����ܵ�ɨ�� 0~9 ����λ(��ͷ������'+'��'-')������A����
        boolean numeric = scanInteger(str, index);
        // 2���������С���� '.' ,��ʼɨ���ʾ��ֵ��С���㲿�֣���B����(��ֵǰ�治����'+'��'-')
        if (index[0] <= str.length - 1 && str[index[0]] == '.') {
            index[0]++;
            // �� �� ���㣬�����������ȷ
            // С����ǰ������������û��   1. --> 1.0
            // ǰ��û������������        .1 --> 0.1
            // ǰ�桢���涼����         1.1 --> 1.1
            numeric = scanUnsignedInteger(str, index) || numeric;
        }
        // 3��������� 'e��E' ,��ʼɨ��ָ�����֣���C����
        if (index[0] <= str.length - 1 && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            // �� �� ����
            // e / E ǰ��û ���� �����    .e1 ��e1
            // e / E ����û ���� �����    12e ��12e+5.4
            numeric = scanInteger(str, index) && numeric;
        }
        return numeric && index[0] == str.length;
    }

    public boolean scanInteger(char[] str, int[] index) {
        if (index[0] <= str.length - 1 && (str[index[0]] == '+' || str[index[0]] == '-')) index[0]++;
        return scanUnsignedInteger(str, index);
    }

    public boolean scanUnsignedInteger(char[] str, int[] index) {
        int before = index[0];
        while (index[0] <= str.length - 1 && str[index[0]] >= 48 && str[index[0]] <= 57) index[0]++;
        return (index[0] > before);
    }
}
