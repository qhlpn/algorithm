package bak.offer;

// �������� n, ��˳���ӡ���� 1 �� ���� n λʮ��������
// �������� 3�� ���ӡ 1 2 3 ... 999

import java.math.BigInteger;

public class _17_Print1ToMaxOfNDigits {

    //////////////////////////////////////////////////////////
    // Ҫ���ǵ� �������� �������ַ����������������

    //////////////////////////////////////////////////////////
    // �ⷨ1�����ַ���(�ַ�����)��ģ�����ּӷ�
    // ע��� 1���ж��Ƿ��� 99...99 ������ boolean ���ɣ�
    //                          �������ñȽ��ַ����Ƿ����
    //       2�����ǵ� 001 Ҫ��ӡ�� 1
    // ���֪ʶ�� System.out.println((int)('9'-'0'));
    //           -->  9   // int��ʡȥ��char - char �Զ�ת��ASCII�����Ӽ���
    //          System.out.println((char)(9+48));
    //           -->  '9'  //  '0'��ASCII����48
    public static void print1ToMaxOfNDigitsI(int n) {
        if (n < 1) return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++)
            number[i] = '0';
        while (!increase(number)) {
            print(n, number);
        }
    }

    public static boolean increase(char[] number) {
        int i;
        int code = 0;
        for (i = 0; i < number.length; i++) {
            code = number[i] - '0' + 1;
            if (code != 10) break;
            number[i] = '0';
        }
        if (i == number.length) {
            return true;
        } else {
            number[i] = (char) (code + 48);
            return false;
        }
    }

    public static void print(int n, char[] number) {
        int high = n - 1;
        while (number[high] == '0') {
            high--;
            if (high == -1) return;
        }

        for (int i = high; i >= 0; i--) {
            System.out.print(number[i]);
        }
        System.out.println();
    }

    //////////////////////////////////////////////////////////
    // �ⷨ2������ [ȫ���� --> �ݹ�] �ⷨ
    // ��λ�����ȴ󡢵�λ������С
    // �ݹ�� ��λ �� ��λ
    public static void print1ToMaxOfNDigitsII(int n) {
        if (n < 1) return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; i++) {
            number[n - 1] = (char) (i + '0');
            increaseRecur(number, n, n - 2);
        }
    }

    public static void increaseRecur(char[] number, int n, int index) {
        if (index == -1) {
            print(n, number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            increaseRecur(number, n, index - 1);
        }
    }

    public static void main(String[] args) {
        _17_Print1ToMaxOfNDigits test = new _17_Print1ToMaxOfNDigits();
        test.printN(2);
    }

    public void printN(int n) {
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        while (increaseOne(num)) {
            printN(num);
        }
    }

    public boolean increaseOne(char[] num) {
        int code = 0;
        int i;
        for (i = 0; i < num.length; i++) {
            code = num[i] - '0' + 1;
            if (code == 10) {
                num[0] = '0';
            } else {
                break;
            }
        }
        if (i == num.length) {
            return false;
        }
        num[i] = (char) (code + 48);
        return true;
    }

    public void printN(char[] num) {
        int index = num.length - 1;
        while (num[index] == '0') {
            index--;
        }
        for (int i = index; i >= 0; i--) {
            System.out.print(num[i]);
        }
        System.out.println();
    }
}
