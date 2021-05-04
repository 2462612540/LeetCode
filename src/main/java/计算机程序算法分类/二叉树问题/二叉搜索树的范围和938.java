package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

/**
 * @Classname 二叉搜索树的范围和938
 * @Description TODO
 * @Date 2021/5/4 9:45
 * @Created by xjl
 */
public class 二叉搜索树的范围和938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int rangeSumBST1(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        //左边
        dfs(root.left, low, high);
        //根
        if (root.val <= high && root.val >= low) {
            sum += root.val;
        }
        //右边
        dfs(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        //当节点的大于的时候应该是的进入左子树
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        //当节点的小于的时候进入右子树
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


}
