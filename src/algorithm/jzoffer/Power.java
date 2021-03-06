package algorithm.jzoffer;

/**
 *
 */
public class Power {

    public double power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow *= base;
        return isNegative ? 1 / pow : pow;
    }
}
