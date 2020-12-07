/**
 * Copyright (C), 2018-2020
 * FileName: inorderTraversal
 * Author:   xjl
 * Date:     2020/3/28 16:04
 * Description: 给定一个二叉树，返回它的中序 遍历。
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        //遍历左节点
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }
        //遍历根节点
        list.add(root.val);
        //遍历右节点
        if (root.right!=null){
            inorderTraversal(root,list);
        }
    }

}
