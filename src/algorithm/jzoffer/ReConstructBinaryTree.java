package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:51
 */
public class ReConstructBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] preorder, int startpreorder, int endpreorder, int[] inorder, int startIn, int endIn) {
        if (startpreorder > endpreorder || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startpreorder]);
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startpreorder]) {
                /**
                 * preorder: {1, 2, 4, 7, 3, 5, 6, 8}
                 * in: {4, 7, 2, 1, 5, 3, 8, 6}
                 *
                 * 从二叉树的性质来看，若以中序遍历的任意节点 i 为根节点，那么0 ~ (i-1)都是其左子树的节点，同理大于i的所有节点皆为其右子树节点。
                 * 另一个问题：如何确定先序遍历中以 i 为根节点，其左子树的节点范围和右子树范围？
                 *          1.如果有二叉树图，可以明确的知道，不管是中序遍历，还是先序遍历，其左子树的节点个数都一致。
                 *          2.从 1 可以得出结论，只要算得分别中序遍历中，以 i 为根节点的左（右）子树节点数
                 *            那么，可以得到先序遍历中的左（右）子树范围 {i - 中序起点 + 先序根起点}
                 *            那么，右子树的起点就是 {i - 中序起点 + 先序根起点 + 1}
                 */
                root.left = reConstructBinaryTree(preorder, startpreorder + 1, startpreorder + i - startIn, inorder, startIn, i - 1);
                root.right = reConstructBinaryTree(preorder, i - startIn + startpreorder + 1, endpreorder, inorder, i + 1, endIn);
            }
        }
        return root;
    }
}
