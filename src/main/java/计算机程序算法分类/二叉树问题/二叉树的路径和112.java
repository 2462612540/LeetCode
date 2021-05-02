package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;

/**
 * @Classname 二叉树的路径和112
 * @Description TODO
 * @Date 2021/4/30 14:18
 * @Created by xjl
 */
public class 二叉树的路径和112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list.contains(targetSum);
    }

    private void dfs(ArrayList<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
        }
        dfs(list, root.left, sum);
        dfs(list, root.right, sum);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        Boolean l = hasPathSum2(root.left, targetSum - root.val);
        Boolean r = hasPathSum2(root.right, targetSum - root.val);
        return l || r;
    }

}
