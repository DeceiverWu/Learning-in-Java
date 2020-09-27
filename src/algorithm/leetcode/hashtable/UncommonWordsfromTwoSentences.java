package algorithm.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : (A + " " + B).split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);

        ArrayList<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1)
                res.add(s);
        }
        return res.toArray(new String[0]);
    }
}
