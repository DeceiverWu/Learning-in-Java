package algorithm.leetcode.backtracking;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while (res.peek().length() != digits.length()) {
            String move = res.remove();
            String map = mapping[digits.charAt(move.length()) - '0'];
            for (char c : map.toCharArray())
                res.add(move + c);
        }
        return res;
    }

    public List<String> letterCombinationsI(String digits) {
        ArrayList<String> res = new ArrayList<>();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        if (digits == null || digits.length() == 0) {
            return res;
        }

        char[] path = new char[digits.length()];
        helper(res, 0, path, map, digits);
        return res;
    }

    public void helper(List<String> res, int index, char[] path, Map<Character, char[]> map, String digits) {
        if (index == digits.length()) {
            res.add(new String(path));
            return;
        } else {
            char[] chars = map.get(digits.charAt(index));
            for (char c : chars) {
                path[index] = c;
                helper(res, index + 1, path, map, digits);
            }
        }
    }

}
