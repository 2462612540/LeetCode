/**
 * Copyright (C), 2018-2020
 * FileName: isSubStructure26
 * Author:   xjl
 * Date:     2020/6/2 15:29
 * Description: 树的子树
 */
package leetcode练习题;

/**
 * 判断这样的结构是采用的是三种方式：
 * 1中的是判断是否为当前的结构 2 判断左子树是否有相同的子树的结构 3 判断右边的是否有相同的子树的结构
 */
public class isSubStructure26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
