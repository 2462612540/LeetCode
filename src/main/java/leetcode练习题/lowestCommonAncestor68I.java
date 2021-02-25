/**
 * Copyright (C), 2018-2020
 * FileName: lowestCommonAncestor68I
 * Author:   xjl
 * Date:     2020/8/20 18:30
 * Description: 二叉树的最近的祖先
 */
package leetcode练习题;

public class lowestCommonAncestor68I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
