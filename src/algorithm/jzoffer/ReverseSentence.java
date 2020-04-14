package algorithm.jzoffer;

/**
 * Input:
 * "I am a student."
 *
 * Output:
 * "student. a am I"
 */
public class ReverseSentence {

    public String reverseSentence(String str) {
        if (str == null || str.length() <= 1)
            return str;
        int len = str.length();
        char[] ch = str.toCharArray();
        int i = 0, j = 0;
        while (j <= len) {
            if (j == len || ch[j] == ' ') {
                reverse(ch, i, j - 1);
                i = j + 1;
            }
            j++;
        }
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
