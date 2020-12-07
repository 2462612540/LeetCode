/**
 * Copyright (C), 2018-2020
 * FileName: 二叉树的最近的公共节点
 * Author:   xjl
 * Date:     2020/10/1 12:54
 * Description:
 */
package 牛客面试必会100题;

public class 二叉树的最近的公共节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return CommonAncestor(root, o1, o2).val;
    }

    public TreeNode CommonAncestor (TreeNode root, int o1, int o2) {
        if (root==null) return null;
        // 超过叶子节点，或者root为p、q中的一个直接返回
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = CommonAncestor(root.left,o1,o2); // 返回左侧的p\q节点
        TreeNode right = CommonAncestor(root.right,o1,o2); // 返回右侧的p\q节点
        if (left == null) {  // 都在右侧
            return right;
        }
        if (right == null) { // 都在左侧
            return left;
        }
        return root; // 在左右两侧
    }
}
