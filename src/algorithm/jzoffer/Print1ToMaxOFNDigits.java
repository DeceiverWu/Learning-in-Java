package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:46
 */
public class Print1ToMaxOFNDigits {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] nums = new char[n];
        print1ToMaxOfNDigits(nums, 0);
    }

    public void print1ToMaxOfNDigits(char[] nums, int digit) {
        if (digit == nums.length) {
            printNum(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(nums, digit + 1);
        }
    }

    public void printNum(char[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == '0')
            index++;
        while (index < nums.length)
            System.out.print(nums[index++]);
        System.out.println();
    }
}
