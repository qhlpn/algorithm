package bak.offer;

import java.util.ArrayList;

// ����һ����������������һ������S��
// �������в�����������ʹ�����ǵĺ�������S��
// ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�

public class _57_01_TwoNumbersWithSum {

    // ˼·һ�� �̶�һ������ƥ��������  ʱ��O(N2)

    // ˼·���� ǰ������ָ�룬��������  ʱ��O(N)
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> al = new ArrayList<>();
        if (array == null || array.length == 0) return al;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int help = array[start] + array[end];
            if (help > sum) {
                end--;
            } else if (help < sum) {
                start++;
            } else {
                al.add(array[start]);
                al.add(array[end]);
                return al;
            }
        }
        return al;
    }
}
