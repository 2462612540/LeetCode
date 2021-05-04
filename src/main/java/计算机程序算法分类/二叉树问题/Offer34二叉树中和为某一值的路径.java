package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Offer34二叉树中和为某一值的路径
 * @Description TODO
 * @Date 2021/5/4 16:30
 * @Created by xjl
 */
public class Offer34二叉树中和为某一值的路径 {

    /**
     * @description TODO  树节点的定义
     * @param: null
     * @date: 2020/12/23 10:36
     * @return:
     * @author: xjl
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
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
