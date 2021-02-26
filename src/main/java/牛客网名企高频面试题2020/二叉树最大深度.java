package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二叉树最大深度
 * Author:   xjl
 * Date:     2020/9/24 9:40
 * Description:
 */


/**
 * 就是二叉树的深度
 */
public class 二叉树最大深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        ans = Math.max(left, right) + 1;
        return ans;
    }
}
