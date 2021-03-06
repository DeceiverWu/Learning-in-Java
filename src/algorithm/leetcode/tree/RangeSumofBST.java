package algorithm.leetcode.tree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-03
 * Time: 19:25
 */

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * <p>
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumofBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        // binary search DFS
        int sum = 0;
        if (root.val > L) sum += rangeSumBST(root.left, L, R);
        if (root.val < R) sum += rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R) sum += root.val;
        return sum;
    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return ((L <= root.val && root.val <= R) ? root.val : 0) + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

}
