package algorithm.leetcode.string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * 判断一个字符串能不能由比它更小的子串构成
 * 解题思路：
 * 1.重复的子串的长度肯定是总长度的因子
 * 2.遍历所有的因子，从length/2开始
 * 2.如果i是length的因子，把从0到i这个substring重复length()/i倍
 * 3.对比这个重复后的串是否与原来的串相等
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                int n = len / i;
                String sub = s.substring(0, i);
                int j;
                for (j = 1; j < n; j++) {
                    // i:子串长度   j:第j个子串
                    // j*i: 第j个子串起始下标  i+j*i: 第j个子串结尾下标
                    // 主要比较第1个子串sub是否与后面几个子串重复
                    if (!sub.equals(s.substring(j * i, i + j * i))) break;
                }
                if (j == n) return true;
            }
        }
        return false;
    }
}
