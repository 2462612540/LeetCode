/**
 * Copyright (C), 2018-2020
 * FileName: isSubtree572
 * Author:   xjl
 * Date:     2020/8/21 9:46
 * Description: 子树
 */
package Tree;

public class isSubtree572 {
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

    public boolean isSubtree(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        return slove(A, B) || isSubtree(A.left, B) || isSubtree(A.right, B);
    }

    private boolean slove(TreeNode s, TreeNode t) {
        if (t == null && s == null)
            return true;
        else if (t == null || s == null)
            return false;
        else if (t.val == s.val)
            return slove(s.left, t.left) && slove(s.right, t.right);
        else
            return false;
    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }


    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
