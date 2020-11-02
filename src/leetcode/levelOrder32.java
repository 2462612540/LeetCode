/**
 * Copyright (C), 2018-2020
 * FileName: levelOrder32
 * Author:   xjl
 * Date:     2020/6/3 15:02
 * Description: 面试题32 - I. 从上到下打印二叉树
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //层序遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    //变式2
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        //保存每一层的二节点的数量个数
        int sum = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int temp = 0;//保存当前层的下一层的节点
            while (sum > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    temp++;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    temp++;
                    queue.add(node.right);
                }
                sum--;
            }
            sum = temp;
            ans.add(list);
        }
        return ans;
    }

    //变式3
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        //保存每一层的二节点的数量个数
        int sum = 1;
        int num = 1;

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int temp = 0;//保存当前层的下一层的节点
            while (sum > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    temp++;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    temp++;
                    queue.add(node.right);
                }
                sum--;
            }
            sum = temp;
            if (num % 2 == 0) {
                for (int i = 0, j = list.size()-1; i < j; i++, j--) {
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
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
        s3.left = s4;
        s3.right = s5;
        List<List<Integer>> lists = levelOrder2(s1);
    }

}
