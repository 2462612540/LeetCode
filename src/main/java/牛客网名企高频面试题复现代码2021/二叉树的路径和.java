package 牛客网名企高频面试题复现代码2021;

/**
 * @Classname 二叉树的路径和
 * @Description TODO
 * @Date 2020/12/19 15:23
 * @Created by xjl
 */
public class 二叉树的路径和 {
    int res = Integer.MIN_VALUE;

    public int TreeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = Math.max(0, getMax(root.left));
        int R = Math.max(0, getMax(root.right));
        res = Math.max(res, Math.max(root.val + Math.max(L, R), root.val + R + L));
        return Math.max(L, R) + root.val;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
