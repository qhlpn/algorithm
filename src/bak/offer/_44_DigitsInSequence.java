package bak.offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 */
public class _44_DigitsInSequence {

    public static int digitsInSequence(int n) {
        if (n < 1) return -1;
        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int help = i;
            int tick = 0;
            do {
                count++;
                tick++;
                help = help / 10;
                if (count == n) {
                    int bit = 0;
                    int a = i;
                    do {
                        a = a / 10;
                        bit++;
                    } while (a != 0);
                    int[] ints = new int[bit];
                    for (int j = 0; i != 0; j++) {
                        ints[j] = (i % 10);
                        i = i / 10;
                    }
                    return ints[bit - tick];
                }
            } while (help != 0);
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(digitsInSequence(i));
        }
    }
}
