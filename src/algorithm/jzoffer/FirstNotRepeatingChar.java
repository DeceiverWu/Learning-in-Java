package algorithm.jzoffer;

import java.util.BitSet;

/**
 *
 */
public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar_1(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    public int firstNotRepeatingChar_2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }
}
