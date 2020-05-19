/**
 * Copyright (C), 2018-2020
 * FileName: Mirror
 * Author:   xjl
 * Date:     2020/5/8 22:27
 * Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
package NiuKeCode;

public class Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //分别去置换左右两边的数据
        Mirror(root.left);
        Mirror(root.right);
    }

}
