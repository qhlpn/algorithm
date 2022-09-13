package bak.offer;

// ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
// ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
// ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
// ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ 3+5+3+7 = 18��
// ���ǣ������ܽ��뷽��35,38������Ϊ 3+5+3+8 = 19��
// ���ʸû������ܹ��ﵽ���ٸ����ӣ�
public class _13_RobotMove {

    //////////////////////////////////////////////////////////
    // ��ά�����˶����� --> ���ݷ�
    // ���ݷ��ؼ��� --> ��־λ�����е���������Ϣ���ռ����۱߽�
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        // �ܴﵽ�ĸ�����
        int[] count = {0};
        getCount(rows, cols, 0, 0, count, flag, threshold);
        return count[0];
    }

    public static void getCount(int rows, int cols, int i, int j, int[] count, boolean[][] flag, int threshold) {
        // Խ�߽硢�ѷ��ʡ�������ֵ �����
        if (i < 0 || i == rows || j < 0 || j == cols || flag[i][j] || initialize(i, j) > threshold) return;
        // ���������ĸ�������1
        count[0]++;
        // ��־λ��Ϊtrue���ѷ���
        flag[i][j] = true;
        // �� ��ǰ�� ����Χ�ĸ�������ж�
        getCount(rows, cols, i, j + 1, count, flag, threshold);
        getCount(rows, cols, i + 1, j, count, flag, threshold);
        getCount(rows, cols, i, j - 1, count, flag, threshold);
        getCount(rows, cols, i + 1, j, count, flag, threshold);
        return;
    }

    // ��������������������λ֮��
    public static int initialize(int i, int j) {
        int num = 0;
        while (i > 0) {
            num += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            num += j % 10;
            j = j / 10;
        }
        return num;
    }

}
