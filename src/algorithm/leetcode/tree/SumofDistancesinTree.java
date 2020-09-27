package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 *
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 *
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 *
 * Example 1:
 *
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Note: 1 <= N <= 10000
 *
 *
 * Explanation
 * 1.Let's solve it with node 0 as root.
 *
 * 2.Initial an array of hashset tree, tree[i] contains all connected nodes to i.
 *   Initial an array count, count[i] counts all nodes in the subtree i.
 *   Initial an array of res, res[i] counts sum of distance in subtree i.
 *
 * 3.Post order dfs traversal, update count and res:
 *   count[root] = sum(count[i]) + 1
 *   res[root] = sum(res[i]) + sum(count[i])
 *
 * 4.Pre order dfs traversal, update res:
 *   When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
 *   res[i] = res[root] - count[i] + N - count[i]
 *
 * 5.return res, done.
 *
 */
public class SumofDistancesinTree {

    private ArrayList<HashSet<Integer>> tree;
    private int[] count;
    private int[] dist;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        count = new int[N];
        dist = new int[N];
        for (int i = 0; i < N; i++)
            tree.add(new HashSet<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postorder(0, -1);
        preorder(0, -1);
        return dist;
    }

    private void postorder(int root, int pre) {
        for (int node : tree.get(root)) {
            if (node == pre) continue;  // 由于是无向图，此处判断是否重复计算边，如[0,1],[1,0]
            postorder(node, root);
            count[root] += count[node];
            dist[root] += count[node] + dist[node];
        }
        count[root]++;
    }

    private void preorder(int root, int pre) {
        for (int node : tree.get(root)) {
            if (node == pre) continue;
            dist[node] = dist[root] - count[node] + count.length - count[node];
            preorder(node, root);
        }
    }
}
