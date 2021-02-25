/**
 * Copyright (C), 2018-2020
 * FileName: increasingBST897
 * Author:   xjl
 * Date:     2020/8/21 14:01
 * Description: zhognxubianli
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;

public class increasingBST897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        /**
         * 重新建立二叉树
         */
        TreeNode ans = new TreeNode(list.get(0)), cur = ans;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return ans;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param list
     */
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
