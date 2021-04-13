package 牛客网名企面试笔试代码复现2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 路径和总结
 * @Description TODO
 * @Date 2021/4/13 8:38
 * @Created by xjl
 */
public class 路径和总结 {
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

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        Boolean l = hasPathSum1(root.left, targetSum - root.val);
        Boolean r = hasPathSum1(root.right, targetSum - root.val);
        return l || r;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, targetSum, root);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int targetSum, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(result,list,targetSum-root.val,root.left);
        dfs(result,list,targetSum-root.val,root.right);
        list.remove(list.size() - 1);
    }

}
