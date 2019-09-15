package algorithm.leetcode.string;

import java.util.ArrayDeque;

/**
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        } else {
            ArrayDeque<Character> deque = new ArrayDeque<>(s.length());
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(': deque.push(')'); break;
                    case '{': deque.push('}'); break;
                    case '[': deque.push(']'); break;
                    case ')': case '}': case ']': if (deque.isEmpty() || deque.pop() != s.charAt(i)) return false;
                }
            }
            return deque.isEmpty();
        }
    }
}
