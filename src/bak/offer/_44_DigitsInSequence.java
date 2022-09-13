package bak.offer;

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
