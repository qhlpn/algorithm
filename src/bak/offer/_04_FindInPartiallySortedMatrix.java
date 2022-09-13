package bak.offer;

// ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
// ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
// �ж��������Ƿ��и�������

public class _04_FindInPartiallySortedMatrix {

    ////////////////////////////////////////////////////////////////////
    // 1�� ���� --> ���ֲ���  ʱ�� O(nlogn) �ռ� O(1)
    // ע�� ���ֲ��ҵ�ϸ��:
    // while (min <= max)
    // ���ֳ� min ~ mid - 1 , mid , mid + 1 ~ max
    // mid = min + ((max - min) >> 1) ��
    // ����� + >> ��ͬ���ģ��������ң�����Ҫ������
    public static boolean find_1(int[][] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (binary_search(arr[i], x)) return true;
        }
        return false;
    }

    public static boolean binary_search(int[] arr, int x) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = min + ((max - min) >> 1);
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }


    ////////////////////////////////////////////////////////////////////
    // ���Ž⣺�����������ϵ��¡����Ҿ�����
    // --> x > arr �� �ұ� + �ϱ�
    // --> x < arr �� ��� + �±�
    // ÿ���������� 2 �������޷�����
    // �����˼·: �п�ס�߽磬�� ���Ͻ� / ���½� ����
    // ʱ�� O(m+n) ~ O(n)
    public static boolean find_2(int[][] arr, int x, int[] resp) {
        int row = arr.length;
        int col = arr[0].length;

        int r = 0;
        int c = col - 1;

        while (r != row && c != -1) {
            if (x > arr[r][c]) {
                r++;
            } else if (x < arr[r][c]) {
                c--;
            } else {
                resp[0] = arr[r][c];
                resp[1] = r;
                resp[2] = c;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int x = 16;
//        int[] resp = new int[3];
//        if (find_2(arr, x, resp)) {
//            System.out.println("arr[" + resp[1] + "][" + resp[2] + "] = " + resp[0]);
//        } else {
//            System.out.println("�����в����� " + x);
//        }
        if (find_1(arr, x)) {
            System.out.println("�����к��� " + x);
        } else {
            System.out.println("�����в����� " + x);
        }
    }

}
