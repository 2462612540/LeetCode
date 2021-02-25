/**
 * Copyright (C), 2018-2020
 * FileName: pruneTree814
 * Author:   xjl
 * Date:     2020/8/21 15:27
 * Description: 树的剪
 */
package leetcode练习题;

public class pruneTree814 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树树的减枝
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

}
