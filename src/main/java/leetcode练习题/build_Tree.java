/**
 * Copyright (C), 2018-2020
 * FileName: build_Tree
 * Author:   xjl
 * Date:     2020/8/2 14:42
 * Description: 构造二叉树
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class build_Tree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 根据层序前序的结果构建二叉树
     *
     * @param treedata
     * @param n
     * @return
     */
    public static TreeNode BuildTree(int[] treedata, int n) {
        if (treedata.length == 0)
            return null;
        else {
            if (n < treedata.length) {
                int l = n * 2 + 1;
                int r = n * 2 + 2;
                TreeNode TreeRoot = new TreeNode(treedata[n], BuildTree(treedata, l), BuildTree(treedata, r));
                return TreeRoot;
            } else
                return null;
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
        Scanner sc = new Scanner(System.in);
        String tempdata = sc.nextLine();

        String[] data = tempdata.split(" ");
        TreeNode treeroot;
        int[] treedata = new int[data.length];
        for (int i = 0; i < treedata.length; i++) {
            treedata[i] = Integer.parseInt(data[i]);
        }
        treeroot = BuildTree(treedata, 0);

        List<Integer> before = before(treeroot);
        List<Integer> mid = mid(treeroot);
        List<Integer> after = after(treeroot);

        //结果的输出
        System.out.print("前序遍历=");
        for (int V : before) {
            System.out.print(V + " ");
        }
        System.out.println();
        System.out.print("中遍历=");
        for (int V : mid) {
            System.out.print(V + " ");
        }
        System.out.println();
        System.out.print("后遍历=");
        for (int V : after) {
            System.out.print(V + " ");
        }
        System.out.println();
    }
}

