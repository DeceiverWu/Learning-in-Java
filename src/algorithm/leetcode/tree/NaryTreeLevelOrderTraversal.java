package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> lvl = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                lvl.add(node.val);
                for (Node c : node.children)
                    queue.add(c);
            }
            res.add(lvl);
        }

        return res;
    }
}
