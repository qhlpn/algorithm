package bak.offer;

// ͳ��һ�����������������г��ֵĴ�����
public class _53_01_NumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == k) count++;
        return count;
    }
}
