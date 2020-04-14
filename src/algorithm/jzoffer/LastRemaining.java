package algorithm.jzoffer;

/**
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并
 * 且不再回到圈中，从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 ....
 * 直到剩下最后一个小朋友，可以不用表演。
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
