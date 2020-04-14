package algorithm.jzoffer;

/**
 * Input:
 * S="abcXYZdef"
 * K=3
 *
 * Output:
 * "XYZdefabc"
 */
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        if (str == null || str.length() <= 1 || n >= str.length())
            return str;
        int len = str.length();
        char[] ch = str.toCharArray();
        reverse(ch, 0, n - 1);
        reverse(ch, n, len - 1);
        reverse(ch, 0, len - 1);
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j)
            swap(ch, i, j);
    }

    private void swap(char[] ch, int i, int j) {
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }
}
