/**
 * Copyright (C), 2018-2020
 * FileName: buildTree07
 * Author:   xjl
 * Date:     2020/6/2 9:33
 * Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
package leetcode;

import java.util.Arrays;

public class buildTree07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //输入的是前序遍历的结果 中序遍历的结果
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归函数的出口是
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //获取到根节点的value的值
        TreeNode root = new TreeNode(preorder[0]);
        //构建left right子树
        int index = findIndex(preorder, inorder);
        // root.left = buildTree( 左子树的前序数组 左子树的中序数组);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        //root.right = buildTree(右子树的前序数组 右子树的中序数组);
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }

    //为了找到中序遍历的过程中位置
    private int findIndex(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                return i;
            }
        }
        return 0;
    }

}
