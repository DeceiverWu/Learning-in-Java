package algorithm.jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:45
 */
public class Permutation {


    public ArrayList<String> permutation(String str) {
        ArrayList<String> sorts = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutation(str.toCharArray(), 0, sorts);
            Collections.sort(sorts);
        }
        return sorts;
    }

    public void permutation(char[] str, int index, ArrayList<String> sorts) {
        if (index == str.length - 1) {
            String s = String.valueOf(str);
            sorts.add(s);
        } else {
            for (int i = index; i < str.length; i++) {
                if (i == index || str[i] != str[index]) {
                    swap(str, index, i);
                    permutation(str, index + 1, sorts);
                    swap(str, index, i);
                }
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        ArrayList<String> ab = permutation.permutation("abcdefg");
        System.out.println(ab.toString());
        System.out.println(ab.size());
        Set<String> set = new HashSet<>(ab);
        System.out.println(set.size());
    }
}
