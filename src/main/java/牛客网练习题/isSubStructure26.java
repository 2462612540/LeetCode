/**
 * Copyright (C), 2018-2020
 * FileName: isSubStructure26
 * Author:   xjl
 * Date:     2020/8/20 16:32
 * Description: 子树
 */
package 牛客网练习题;

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
        //递归出口 只要有一个等于空的话那就不是子树
        if (A == null || B == null) {
            return false;
        }
        //递归函数 判断AB两个树 判断是 A左子树 B 是否相同 A的右边的子树和B是否相同
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
