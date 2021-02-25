/**
 * Copyright (C), 2018-2020
 * FileName: kthLargest
 * Author:   xjl
 * Date:     2020/4/4 10:57
 * Description: 二叉搜索树的第k大节点
 */
package leetcode练习题;

import org.junit.Test;

public class kthLargest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(kthLargest(n1, 2));
    }
}
