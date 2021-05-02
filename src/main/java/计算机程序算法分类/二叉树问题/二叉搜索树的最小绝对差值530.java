package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

import java.util.ArrayList;

/**
 * @Classname 二叉搜索树的最小绝对差值530
 * @Description TODO
 * @Date 2021/4/30 16:52
 * @Created by xjl
 */
public class 二叉搜索树的最小绝对差值530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {

        ans = Integer.MAX_VALUE;
        pre = -1;
        //采用的是的df
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root);
        //计算差值
        return ans;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
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
