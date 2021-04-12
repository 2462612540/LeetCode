package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 路径和II  求解的二叉树中的所有的目标的路径和的数组
 * @Description TODO
 * @Date 2021/4/12 20:36
 * @Created by xjl
 */
public class 路径和II {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        dfs(root, result, list, targetSum);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> list, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, result, list, sum - root.val);
        dfs(root.right, result, list, sum - root.val);

        list.remove(list.size() - 1);

    }
}
