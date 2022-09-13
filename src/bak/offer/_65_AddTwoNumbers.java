package bak.offer;

// дһ������������������֮��
// Ҫ���ں������ڲ���ʹ�� +��-��*��/ ����������š�

public class _65_AddTwoNumbers {

    // ˼·��λ����
    // ��һ�����ӷ���������λ�� --> ���
    // �ڶ�������λ --> ������ + ���� 1 λ
    // ����������λ������ٴν�λ���ػص�һ����

    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
