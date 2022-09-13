package bak.offer;

// ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
// ģʽ�е��ַ�'.'��ʾ����һ���ַ���
// ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
// �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
// ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬
// ������"aa.a"��"ab*a"����ƥ��

public class _19_RegularExpressionsMatching {

    // https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
    // ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
    //      1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
    //      2������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��

    // ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
    // ����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣
    // ����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������2��ƥ�䷽ʽ��
    //      1���ַ���������ģʽ����2�ַ����൱�� x* ������
    //      2���ַ�������1�ַ���ģʽ����������ƥ���ַ���һλ

    //////////////////////////////////////////////////////////
    // �����ݹ�(Ϊʲô�����õݹ飿����ö�٣�)
    // �ݹ��ǹ��ڳ��ԵĹ���
    public static boolean match(char[] str, char[] pattern) {
        // ��������������
        // int[] c = null ; c.length == 0 ; java.lang.NullPointerException
        // int[] c = {}   ; c.length == 0 ; true
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // ��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        // pattern�ȵ�β��ƥ��ʧ��
        // str�л����ȵ�β  str = 'a' �� pattern = 'ab*'
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        // ģʽ��2���� *
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // �ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ
            if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                // ģʽ����2����Ϊ x* ƥ��0���ַ�
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        // * ƥ��1������ƥ��str�е���һ��
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
                // �粻ƥ�䣬ģʽ����2λ
            } else return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
        //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
        if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.'))
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        return false;
    }

    public static void main(String[] args) {
        char[] str = {'a'};
        char[] pattern = {'a', '.'};
        System.out.println(match(str, pattern));
    }
}
