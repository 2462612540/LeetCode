package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二叉树的路径总和II113
 * @Description TODO
 * @Date 2021/4/30 13:01
 * @Created by xjl
 */
public class 二叉树的路径总和II113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pahtsum(TreeNode root, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<Integer> list = new ArrayList<>();
        dfs(root, lists, list, target, 0);
        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> lists, List<Integer> list, int target, int sum) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == sum) {
                lists.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, lists, list, target, sum);
        dfs(root.right, lists, list, target, sum);
        list.remove(list.size() - 1);
    }
}
