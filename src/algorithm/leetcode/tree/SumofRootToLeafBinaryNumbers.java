package algorithm.leetcode.tree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 09:29
 */

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class SumofRootToLeafBinaryNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return getSumForAllRootToLeaf(root, 0, 0);
    }

    public int getSumForAllRootToLeaf(TreeNode root, int total, int curSum) {
        if (root == null) return total;

        curSum = curSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            total += curSum;
            return total;
        }
        total = getSumForAllRootToLeaf(root.left, total, curSum);
        return getSumForAllRootToLeaf(root.right, total, curSum);
    }
}
