package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

/**
 * @Classname 左叶子的和
 * @Description TODO
 * @Date 2021/4/30 14:47
 * @Created by xjl
 */
public class 左叶子的和 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            //如这个左边的节点是最后节点那就不用递归下去 否者需要递归加起来
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null) {
            ans += isLeafNode(node.right) ? 0 : dfs(node.right);
        }
        return ans;
    }

    //判断是否的最后的叶子节点
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    //所有的右边的节点的和
    public int sumOfRightLeaves(TreeNode root) {
        return root != null ? dfsright(root) : 0;
    }

    private int dfsright(TreeNode root) {
        int ans = 0;
        if (root.right != null) {
            ans += isLeafNode(root.right) ? root.right.val : dfs(root.right);
        }
        if (root.left != null) {
            ans += isLeafNode(root.left) ? 0 : dfs(root.left);
        }
        return ans;
    }
}
