package algorithm.leetcode.math;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-11
 * Time: 18:22
 */

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 */
public class AddDigits {

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
