package algorithm.jzoffer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:39
 */
public class FindPathByTargetSum {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    //public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
    //    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    //    if (root == null || target <= 0) {
    //        return paths;
    //    }
    //    int currentSum = 0;
    //    ArrayList<Integer> path = new ArrayList<>();
    //    findPath(root, paths, target, currentSum, path);
    //    return paths;
    //}
    //
    //public void findPath(TreeNode root, ArrayList<ArrayList<Integer>> paths, int target,
    //                     int currentSum, ArrayList<Integer> currentPath) {
    //    currentSum += root.val;
    //    currentPath.add(root.val);
    //
    //    boolean isLeaf = (root.left == null && root.right == null);
    //    if (isLeaf && currentSum == target) {
    //        paths.add(new ArrayList<>(currentPath));
    //    }
    //
    //    if (root.left != null) {
    //        findPath(root.left, paths, target, currentSum, currentPath);
    //    }
    //    if (root.right != null) {
    //        findPath(root.right, paths, target, currentSum, currentPath);
    //    }
    //    currentPath.remove(currentPath.size() - 1);
    //}

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left ==null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
