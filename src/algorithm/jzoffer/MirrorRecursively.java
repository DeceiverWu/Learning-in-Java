package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:42
 */
public class MirrorRecursively {

    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
    }

    public void mirror(TreeNode root) {
        if (root == null)
            return;

        swap(root);

        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode node) {
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
    }
}
