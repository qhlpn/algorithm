package bak.offer;

// 字符流中第一个只出现一次的字符

public class _50_02_FirstCharacterInStream {

    private int[] asc = new int[256];
    private int index = 0;


    // Insert one char from stringstream
    public void Insert(char ch) {
        index++;
        if (asc[(int) ch] == 0) {
            asc[(int) ch] = index;
        } else if (asc[(int) ch] > 0) {
            asc[(int) ch] = -1;
        }

    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char resp = '#';
        for (int i = 0; i < asc.length; i++) {
            if (asc[i] > 0 && minIndex > asc[i]) {
                minIndex = asc[i];
                resp = (char) i;
            }
        }
        return resp;
    }
}
