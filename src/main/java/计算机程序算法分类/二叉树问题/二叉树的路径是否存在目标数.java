package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;

/**
 * @Classname 二叉树的路径是否存在目标数
 * @Description TODO
 * @Date 2021/4/30 10:01
 * @Created by xjl
 */
public class 二叉树的路径是否存在目标数 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        Boolean l = hasPathSum(root.left, targetSum - root.val);
        Boolean r = hasPathSum(root.right, targetSum - root.val);
        return l || r;
    }

   //这个就是一个暴力的解法
    public boolean hasPathSumTest(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list.contains(targetSum);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
        } else {
            dfs(root.left, list, sum);
            dfs(root.right, list, sum);
        }
    }
}
