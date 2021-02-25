/**
 * Copyright (C), 2018-2020
 * FileName: isSameTree100
 * Author:   xjl
 * Date:     2020/8/7 8:53
 * Description: 同一棵树
 */
package leetcode练习题;

public class isSameTree100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 只有在两个根节点的总是的null的时候才true
        if (p == null && q == null) return true;
        // 如果有其中一个等于的时候就返回false
        if (q == null || p == null) return false;
        //如果当根节点的值的时候不想等于的时候直接返回false
        if (p.val != q.val) return false;
        //嵌套的判断左右子树
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    //判断是否为子树
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //递归出口
        if (A == null || B == null) {
            return false;
        }
        //递归函数
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private Boolean help(TreeNode A, TreeNode B) {
        //递归出口
        if (B == null) return true;
        //B已经不是空 但是A为空的时候
        if (A == null) return false;
        //递归函数
        return A.val == B.val && help(A.left, B.left) && help(A.right, B.right);
    }
}
