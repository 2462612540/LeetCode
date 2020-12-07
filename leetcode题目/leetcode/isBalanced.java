/**
 * Copyright (C), 2018-2020
 * FileName: isBalanced
 * Author:   xjl
 * Date:     2020/4/4 9:56
 * Description: 判断是否为平衡二叉树
 */
package leetcode;

import org.junit.Test;

public class isBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;//这里是用来表示在左子树中的左右子树的差值大于2的时候
        int right = recur(root.right);
        if (right == -1) return -1;//这里是用来表示在右子树中的左右子树的差值大于2的时候
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left=maxDepth(root.left);
        int ringht=maxDepth(root.right);
        return Math.max(left,ringht) + 1;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        isBalanced(n1);
    }

}
