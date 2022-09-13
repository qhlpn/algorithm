package bak.offer;

// �ҳ�����������һ���ظ������֣����ܴ��ڣ�
// ��һ������Ϊ n ����������������ֶ��� 0 ~ n-1 ��Χ

import java.util.HashSet;

public class _03_01_DuplicationInArray {

    ////////////////////////////////////////////////////////////////
    // 1�������ɨ����������  ʱ�� O(nlogn) + O(n) ~ O(nlogn)
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, (int) (l + Math.random() * (r - l + 1)), r);
            int[] p = partiton(arr, l, r);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[1], r);
        }
    }

    public static int[] partiton(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less, more + 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean duplicate_01(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        quickSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                resp[0] = arr[i];
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////
    // 2��ɨ�����飬���ù�ϣ��  ʱ�� O(n) �ռ� O(n)
    public static boolean duplicate_02(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        HashSet<Integer> con = new HashSet();
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = con.add(arr[i]);
            if (!flag) {
                resp[0] = arr[i];
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////
    // 3����ѽ� (��������: ���鳤�� N,ֵ��Χ 0 ~ N-1)
    // ˼·����ͷ�������飬�ж�����ֵ���±�ֵ�Ƿ���ȡ�
    //      �� --> �������������� --> �ж�����ֵ���±�������ֵ������ֵ�Ƿ����
    //                             �� --> �ҵ��ظ��������� --> ����������������ֵ��λ(����ֵ�����±�ֵ)
    // ʱ�� O(n) �ռ� O(1)
    public static boolean duplicate_03(int[] arr, int[] resp) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    resp[0] = arr[i];
                    return true;
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 1, 3, 2, 1};
        int[] resp = new int[1];
        boolean flag = duplicate_03(arr, resp);
        if (flag) {
            System.out.println("�ظ��������� " + resp[0]);
        } else {
            System.out.println("�������ظ�������");
        }
    }
}
