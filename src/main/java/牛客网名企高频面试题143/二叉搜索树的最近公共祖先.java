package 牛客网名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二叉搜索树的最近公共祖先
 * Author:   xjl
 * Date:     2020/10/1 12:56
 * Description:
 */


public class 二叉搜索树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
