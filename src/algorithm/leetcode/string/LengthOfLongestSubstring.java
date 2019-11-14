package algorithm.leetcode.string;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int start = 0;
        int longestSubstring = 0;
        int[] pos = new int[256];
        for (int i = 0; i < 256; i++) {
            pos[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (pos[s.charAt(i)] < start) {
                pos[s.charAt(i)] = i;
                longestSubstring = Math.max(i - start + 1, longestSubstring);
            } else {
                start = pos[s.charAt(i)] + 1;
                pos[s.charAt(i)] = i;
            }
        }
        return longestSubstring;
    }
}
