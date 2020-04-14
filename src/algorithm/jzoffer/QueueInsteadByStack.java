package algorithm.jzoffer;

import java.util.Stack;

/**
 *
 */
public class QueueInsteadByStack {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception();
        }
        return out.pop();
    }
}
