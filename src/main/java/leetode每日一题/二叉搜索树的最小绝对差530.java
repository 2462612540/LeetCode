package leetode每日一题;

import 牛客网练习题.Solution;

/**
 * @Classname 二叉搜索树的最小绝对差530  二叉搜索树中序遍历得到的值序列是递增有序的，
 * @Description TODO  求解的是根的节点的两个元素的差值 就是一个二叉树的中序遍历问题 然后找到相邻的元素的差值的最小的值 这个就需要额外的数组空间 就是记录一下面一个和当前的差值最小的哪一个就行
 * @Date 2021/4/13 8:49
 * @Created by xjl
 */
public class 二叉搜索树的最小绝对差530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int pre;//变量保存前驱节点的值 一开始应该是最小的值 然后就是越来越大
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
