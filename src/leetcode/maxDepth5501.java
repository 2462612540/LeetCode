/**
 * Copyright (C), 2018-2020
 * FileName: maxDepth5501
 * Author:   xjl
 * Date:     2020/8/20 16:19
 * Description: 二叉树的深度
 */
package leetcode;

/**
 * 树的深度
 */
public class maxDepth5501 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? +1 : right + 1;
    }
}


