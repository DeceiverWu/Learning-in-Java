package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                res.push(node.val);
                for (Node n : node.children)
                    stack.push(n);
            }
        }

        return res;
    }

}
