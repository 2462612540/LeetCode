/**
 * Copyright (C), 2018-2020
 * FileName: reConstructBinaryTree
 * Author:   xjl
 * Date:     2020/6/2 10:26
 * Description: 重建简历二叉树
 */
package 牛客网练习题;

import java.util.Arrays;

public class reConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //递归函数的出口
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = findindex(pre, in);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }

    public int findindex(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                return i;
            }
        }
        return -1;
    }
}
