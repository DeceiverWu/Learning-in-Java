package algorithm.jzoffer;

/**
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 */
public class Multiply {

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int i = 0, product = 1; i < len; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = len - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
