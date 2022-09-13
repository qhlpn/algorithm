package bak.offer;

import java.util.ArrayList;

// ����һ������ s
// ��ӡ�����к�Ϊ s ������������
// (���ٺ���������)

public class _57_02_ContinuousSequenceWithSum {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if (sum < 1) return all;
        int start = 1;
        int end = 2;
        while (start <= sum / 2) {
            if (start == end) end++;
            int help = (start + end) * (end - start + 1) / 2;
            if (help > sum) {
                start++;
            } else if (help < sum) {
                end++;
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    al.add(i);
                all.add(al);
                start++;
            }
        }
        return all;
    }

    public static void main(String[] args) {
        ArrayList al = FindContinuousSequence(15);
        System.out.println();
    }
}
