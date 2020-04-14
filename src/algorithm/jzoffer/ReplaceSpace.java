package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:54
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int origin = str.length() - 1;
        int numOfBlank = 0;

        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                numOfBlank++;
            }
        }

        int newLength = origin + numOfBlank * 2 + 1;
        str.setLength(newLength);
        newLength = newLength - 1;
        while (origin >= 0 && newLength > origin) {
            if (str.charAt(origin) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else {
                str.setCharAt(newLength--, str.charAt(origin));
            }
            origin--;
        }

        return str.toString();
    }
}
