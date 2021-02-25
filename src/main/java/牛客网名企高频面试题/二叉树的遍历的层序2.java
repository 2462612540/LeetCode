package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二叉树的遍历的打印
 * Author:   xjl
 * Date:     2020/9/13 21:26
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的遍历的层序2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> test(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        int sum = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum > 0) {
                TreeNode node1 = deque.poll();
                list.add(node1.val);
                if (node1.left != null) {
                    temp++;
                    deque.add(node1.left);
                }
                if (node1.right != null) {
                    temp++;
                    deque.add(node1.right);
                }
                sum--;
            }
            sum = temp;
            lists.add(list);
        }
        //也是可以在这里记性将偶数的来翻转一次
        return lists;
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

        ArrayList<ArrayList<Integer>> lists = test(s1);
        for (ArrayList<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
