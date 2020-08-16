/**
 * Copyright (C), 2018-2020
 * FileName: isSubStructure
 * Author:   xjl
 * Date:     2020/8/14 16:25
 * Description:
 */
package Tree;

public class isSubStructure {

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
        /**
         * 保证其中一个就可以了成立就可以
         */
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断是否相同
     * @param A
     * @param B
     * @return
     */
    private Boolean help(TreeNode A, TreeNode B) {
        //当比较B结束 那么就是
        if (B == null) return true;
        //B已经不是空 但是A为空的时候B还没有搞完
        if (A == null) return false;
        //保证值相等 而且要保证是的是左子树等于左子树 右子树等于右子树
        return A.val == B.val && help(A.left, B.left) && help(A.right, B.right);
    }
}
