package algorithm.test;

public class IsPrimeTest {

    public boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    private static boolean[] prime = new boolean[1024 * 1024];

    private static int maxPrimeIndex = 0;

    public void getPrime(int[] nums) {
        boolean isPrime = true;
        // init boolean array all is true
        prime[0] = prime[1] = true;
        for (int i = 2; i < nums.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < nums.length; i++) {
            if (prime[i])
                for (int j = 2 * i; j < nums.length; j = j + i)
                    prime[j] = false;
        }
    }
}
