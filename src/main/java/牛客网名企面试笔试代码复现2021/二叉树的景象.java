package 牛客网名企面试笔试代码复现2021;

import 牛客网名企面试笔试问题2021.二叉树的景象文件;

/**
 * @Classname 二叉树的景象
 * @Description TODO
 * @Date 2021/3/8 9:59
 * @Created by xjl
 */
public class 二叉树的景象 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmep = root.left;
        root.left = root.right;
        root.right = tmep;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
