package algorithm.leetcode.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ')
            tail--;
        if (tail == -1) return 0;
        int start = tail;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        return tail - start;
    }
}
