package 牛客网名企高频面试题2020;

import java.util.ArrayList;

/**
 * @Classname 二叉树的路径和II
 * @Description TODO
 * @Date 2020/12/18 9:49
 * @Created by xjl
 */
public class 二叉树的路径和II {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int current = 0;
        dfs(root, sum, current, list, ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int current, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        current += root.val;
        //判断条件
        if (root.left == null && root.right == null) {
            //终止条件
            if (sum == current) {
                ans.add(new ArrayList<>(list));
            }
        } else {
            dfs(root.left, sum, current, list, ans);
            dfs(root.right, sum, current, list, ans);
        }
        //回溯
        list.remove(list.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
