/**
 * Copyright (C), 2018-2020
 * FileName: lowestCommonAncestor
 * Author:   xjl
 * Date:     2020/4/4 8:11
 * Description: 二叉树的最近公共祖先
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class lowestCommonAncestor {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //首先要检查当前的root情况，若为null就直接返回；
        //若为p、q则是满足最近公共节点为节点本身
        if (root == null || root == p || root == q)
            return root;
        //再利用递归从根节点开始，开始向下遍历每个节点（以下两步则为具体对每一个节点的左右子树查找），由上述if语句的返回值得到这两个节点的值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //对于left和right节点返回的情况，如果根节点的左子树/右子树找不到最近公共节点，那么就说明在右子树/左子树当中
        if (left == null)
            return right;
        if (right == null)
            return left;
        //如果上述两个情况都不符合 则说明根节点就是最近公共节点，直接返回
        return root;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        System.out.println(lowestCommonAncestor(n1, n4, n8).val);

    }
}
