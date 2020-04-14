package algorithm.jzoffer;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 */
public class GetUglyNumber {

    public int getUglyNumber(int N) {
        if (N <= 6)
            return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] res = new int[N];
        res[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = res[i2] * 2, next3 = res[i3] * 3, next5 = res[i5] * 5;
            res[i] = Math.min(next2, Math.min(next3, next5));
            if (res[i] == next2)
                i2++;
            if (res[i] == next3)
                i3++;
            if (res[i] == next5)
                i5++;
        }
        return res[N - 1];
    }
}
