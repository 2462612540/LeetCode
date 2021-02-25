/**
 * Copyright (C), 2018-2020
 * FileName: isSymmetric28
 * Author:   xjl
 * Date:     2020/8/20 16:52
 * Description: 对称二叉树
 */
package leetcode练习题;

public class isSymmetric28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        //如果两个树都是空的话那就正确的
        if(L == null && R == null) return true;
        //如果有其中一个那就不是对称的结构
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
