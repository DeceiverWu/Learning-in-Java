package algorithm.jzoffer;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:56
 */
public class StackIncludMinFunc {

    Stack<Integer> datas = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        datas.push(node);
        if (min.size() == 0 || min.peek() > node) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (datas.size() > 0 && min.size() > 0) {
            datas.pop();
            min.pop();
        }
    }

    public int top() {
        return datas.peek();
    }

    public int min() {
        return min.peek();
    }
}
