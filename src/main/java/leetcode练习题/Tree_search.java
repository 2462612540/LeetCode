/**
 * Copyright (C), 2018-2020
 * FileName: Tree_search
 * Author:   xjl
 * Date:     2020/7/28 10:18
 * Description: 二叉树的遍历
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree_search {
    //初始化类

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //前序
    public static List<Integer> before(TreeNode root) {
        List<Integer> list = beforetest(root, new ArrayList<>());
        return list;
    }

    /**
     * 前序遍历的是的 根左右
     *
     * @param root
     * @param list
     * @return
     */
    public static List<Integer> beforetest(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        if (root.left != null) {
            beforetest(root.left, list);
        }
        if (root.right != null) {
            beforetest(root.right, list);
        }
        return list;
    }

    //中序
    public static List<Integer> mid(TreeNode root) {
        List<Integer> reslut = midtest(root, new ArrayList<>());
        return reslut;
    }

    /**
     * 中序遍历是左根右
     *
     * @param root
     * @param list
     * @return
     */
    public static List<Integer> midtest(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            beforetest(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            beforetest(root.right, list);
        }
        return list;
    }

    //后序
    public static List<Integer> after(TreeNode root) {
        List<Integer> list = aftertest(root, new ArrayList<>());
        return list;
    }

    /**
     * 后序遍历左右根
     *
     * @param root
     * @param list
     * @return
     */
    public static List<Integer> aftertest(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            beforetest(root.left, list);
        }

        if (root.right != null) {
            beforetest(root.right, list);
        }
        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        //函数的调用
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        s1.left = s2;
        s1.right = s3;
        List<Integer> before = before(s1);
        List<Integer> mid = mid(s1);
        List<Integer> after = after(s1);
        //结果的输出
        for (int V:before){
            System.out.print(V+" ");
        }
        System.out.println();
        for (int V:mid){
            System.out.print(V+" ");
        }
        System.out.println();
        for (int V:after){
            System.out.print(V+" ");
        }
        System.out.println();

    }

}
