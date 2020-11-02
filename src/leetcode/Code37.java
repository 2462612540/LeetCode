/**
 * Copyright (C), 2018-2020
 * FileName: Code37
 * Author:   xjl
 * Date:     2020/8/20 16:41
 * Description: 序列化和反序列的
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code37 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Encodes a tree to a single string. 就是一个层序的遍历
    public String serialize(TreeNode root) {
        //存放遍历结果，然后返回
        List<Integer> result = new ArrayList<>();
        //判断时候为空
        if (root == null) {
            return null;
        }
        //存放节点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            /*
            处理 TreeNode 节点 的逻辑
             */
            result.add(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result.toArray().toString();
    }

    // Decodes your encoded data to tree. 二叉树的重建

    public TreeNode deserialize(String data) {
        int[] treedata = new int[data.length()];
        for (int i = 0; i < data.length(); i++) {
            treedata[i] = Integer.valueOf(data.charAt(i));
        }
        //构建二叉树
        TreeNode root = BuildTree(treedata, data.length());
        return root;
    }

    public TreeNode BuildTree(int[] treedata, int n) {
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
}
