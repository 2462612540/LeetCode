package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

/**
 * @Classname 对称二叉树
 * @Description TODO
 * @Date 2021/4/30 13:34
 * @Created by xjl
 */
public class 对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    //这个也是判断两个树是否相同
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
