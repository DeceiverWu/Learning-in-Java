package algorithm.jzoffer;

/**
 * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，
 * 要求不能使用字符串转换整数的库函数
 *
 * Iuput:
 * +2147483647
 * 1a33
 *
 * Output:
 * 2147483647
 * 0
 */
public class StrToInt {

    public int strToInt(String str) {
        if (str == null)
            return 0;
        int res = 0;
        int len = str.length();
        boolean negative = false;
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;
        int i = 0;

        if (len > 0) {
            char first = str.charAt(0);
            if (first < '0') {
                if (first == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (first != '+') {
                    return 0;
                }
                if (len == 1)
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
             digit = str.charAt(i++) - '0';
             if (digit < 0 || digit > 9)
                 return 0;
             if (res < multmin)
                 return 0;
             res *= 10;
             if (res < limit + digit)
                 return 0;
             res -= digit;
            }
        } else {
            return 0;
        }
        return negative ? res : -res;
    }
}
