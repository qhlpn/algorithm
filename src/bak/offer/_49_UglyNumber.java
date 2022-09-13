package bak.offer;

// 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。
// 求按从小到大的顺序的第N个丑数。

public class _49_UglyNumber {

    public static int GetUglyNumber_SolutionI(int index) {
        if (index < 1) return 0;
        int num = 0;
        int count = 0;
        while (count < index) {
            if (IsUgly(++num))
                ++count;
        }
        return num;
    }

    public static boolean IsUgly(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1 ? true : false;
    }

    public static int GetUglyNumber_SolutionII(int index) {
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            uglyNum[i] = Math.min(uglyNum[t2] * 2, Math.min(uglyNum[t3] * 3, uglyNum[t5] * 5));
            if (uglyNum[i] == uglyNum[t2] * 2) t2++;
            if (uglyNum[i] == uglyNum[t3] * 3) t3++;
            if (uglyNum[i] == uglyNum[t5] * 5) t5++;
        }
        return uglyNum[index - 1];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(GetUglyNumber_SolutionI(i));
            System.out.println(GetUglyNumber_SolutionII(i));
            System.out.println();
        }

    }
}
