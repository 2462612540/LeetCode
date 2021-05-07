package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;

/**
 * @Classname 二叉搜索树中第K小的元素230
 * @Description TODO
 * @Date 2021/5/7 10:05
 * @Created by xjl
 */
public class 二叉搜索树中第K小的元素230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
