package algorithm.jzoffer;

/**
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C
 */
public class Sum {

    public int sum(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }
}
