package bak.offer;

// ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
// ���������ַ��� abc ,���ӡ�����ַ� a,b,c
// �������г����������ַ��� abc , acb , bac , bca , cab �� cba��

import java.util.ArrayList;
import java.util.Collections;

public class _38_StringPermutation {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> al = new ArrayList<>();
        char[] chars = str.toCharArray();
        int index = 0;
        RecurPermutation(chars, index, al);
        Collections.sort(al);
        return al;
    }

    public static void RecurPermutation(char[] chars, int index, ArrayList<String> al) {
        if (index == chars.length - 1) {
            if (!al.contains(String.valueOf(chars)))
                al.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            RecurPermutation(chars, index + 1, al);
            swap(chars, i, index);
        }
    }

    public static void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public static void main(String[] args) {
        String str = "CBA";
        ArrayList<String> al = Permutation(str);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
