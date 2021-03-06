package algorithm.leetcode.dynamicprogramming;

/**
 * A program was supposed to print an array of integers. The program forgot to print whitespaces and
 * the array is printed as a string of digits and all we know is that all integers in the array were
 * in the range [1, k] and there are no leading zeros in the array.
 *
 * Given the string s and the integer k. There can be multiple ways to restore the array.
 *
 * Return the number of possible array that can be printed as a string s using the mentioned program.
 *
 * The number of ways could be very large so return it modulo 10^9 + 7
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1000", k = 10000
 * Output: 1
 * Explanation: The only possible array is [1000]
 * Example 2:
 *
 * Input: s = "1000", k = 10
 * Output: 0
 * Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
 * Example 3:
 *
 * Input: s = "1317", k = 2000
 * Output: 8
 * Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
 * Example 4:
 *
 * Input: s = "2020", k = 30
 * Output: 1
 * Explanation: The only possible array is [20,20]. [2020] is invalid because 2020 > 30. [2,020] is ivalid because 020 contains leading zeros.
 * Example 5:
 *
 * Input: s = "1234567890", k = 90
 * Output: 34
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5.
 * s consists of only digits and doesn't contain leading zeros.
 * 1 <= k <= 10^9.
 */
public class RestoreTheArray {

    public int numberOfArrays(String s, int k) {
        Integer[] dp = new Integer[s.length()];
        return numberOfArrays(s, k, 0, dp);
    }

    private int numberOfArrays(String s, int k, int index, Integer[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != null) return dp[index];    // 防止相同元素重复计算
        int num = 0;
        int ans = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > k) break;
            ans += numberOfArrays(s, k, i + 1, dp);
            ans %= 1000000007;
        }
        return dp[index] = ans;
    }

    public int numberOfArraysIterative(String s, int k) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            long num = 0;
            for (int j = i + 1; j <= s.length(); j++) {
                num = num * 10 + s.charAt(j - 1) - '0';
                if (num > k) break;
                dp[i] = (dp[i] + dp[j]) % 1000000007;
            }
        }
        return dp[0];
    }

}
