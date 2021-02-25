package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 层序遍历1
 * Author:   xjl
 * Date:     2020/9/14 9:14
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的遍历的层序1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> cengxu(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode s1 = new TreeNode(3);
        TreeNode s2 = new TreeNode(9);
        TreeNode s3 = new TreeNode(20);
        TreeNode s4 = new TreeNode(15);
        TreeNode s5 = new TreeNode(7);
        s1.left = s2;
        s1.right = s3;

        s2.left = s4;
        s2.right = s5;

        ArrayList<Integer> ans = cengxu(s1);
        System.out.println(ans.toString());
    }
}
