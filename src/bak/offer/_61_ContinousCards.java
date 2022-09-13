package bak.offer;

// ���˿����������ȡ5����
// �ж��ǲ���һ��˳��

import java.util.Arrays;

public class _61_ContinousCards {

    // ˼·��
    // ���� --> ͳ��0�ĸ��� -->
    // �жϷ�0�����������޵�ֵ -->
    // ͳ�������������������ּ�Ŀո���

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5)
            return false;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] < 0 || numbers[i] > 13)
                return false;
        Arrays.sort(numbers);
        int numOfZero = 0;
        int numOfGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
            } else {
                while (i + 1 < numbers.length) {
                    numOfGap += numbers[i + 1] - numbers[i] - 1;
                    i++;
                }
                break;
            }
        }
        if (numOfZero == 4 || numOfGap == numOfZero)
            return true;
        return false;
    }
}
