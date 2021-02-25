package 牛客网名企高频面试题;

/**
 * @Classname 二叉树的路径和I
 * @Description TODO
 * @Date 2020/12/16 12:21
 * @Created by xjl
 */
public class 二叉树的路径和I {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (sum - root.val == 0);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
