package bak.offer;

// ����һ���������飬
// �жϸ������ǲ���ĳ�����������ĺ�������Ľ����
// ����������Yes,�������No��
// �������������������������ֶ�������ͬ��

public class _33_SquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return process(sequence, 0, sequence.length - 1);
    }

    public static boolean VerifySquenceOfBST(int[] sequence, int head, int rear) {
        if (head == rear) return true;
        int temp = head;
        while (sequence[head] < sequence[rear]) head++;
        boolean leftFlag = true;
        if (head != temp)
            leftFlag = VerifySquenceOfBST(sequence, temp, head - 1);
        for (int i = head; i < rear; i++) {
            if (sequence[i] < sequence[rear]) return false;
        }
        boolean rightFlag = true;
        if (head != rear)
            rightFlag = VerifySquenceOfBST(sequence, head, rear - 1);
        return leftFlag && rightFlag;
    }

    public static void main(String[] args) {
        int[] sequence = {4, 6, 5, 7};
        System.out.println(VerifySquenceOfBST(sequence));
    }

    public static boolean process(int[] arr, int first, int last) {
        if (first >= last) {
            return true;
        }
        int cut = -1;
        for (int i = first; i < last && arr[i] < arr[last]; ++i) {
            cut = i;
        }
        cut = cut == -1 ? first : cut + 1;
        for (int i = cut; i < last; i++) {
            if (arr[i] < arr[last]) {
                return false;
            }
        }
        return process(arr, first, cut - 1) && process(arr, cut, last - 1);
    }

}
