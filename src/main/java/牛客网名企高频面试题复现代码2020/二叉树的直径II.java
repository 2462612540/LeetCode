package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 二叉树的直径II
 * @Description TODO
 * @Date 2020/12/19 15:35
 * @Created by xjl
 */
public class 二叉树的直径II {
    int maxD = 1;

    public int MaxD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getD(root);
        return maxD - 1;
    }

    private int getD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getD(root.left);
        int R = getD(root.right);
        maxD = Math.max(maxD, L + R + 1);
        return Math.max(L, R) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
