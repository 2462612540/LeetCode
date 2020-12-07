package 名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.平衡二叉树的
 * Author:   xjl
 * Date:     2020/10/1 12:45
 * Description:
 */


public class 平衡二叉树的 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return test(root) != -1;
    }

    private int test(TreeNode root) {
        if (root == null) return 0;
        int left = test(root.left);
        if (left == -1) return -1;
        int right = test(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
