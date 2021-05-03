package 计算机程序算法分类.二叉树问题;

import java.util.Map;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2021/5/2 19:26
 * @Created by xjl
 */
public class 二叉树的最大深度复现 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxdeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        return Math.max(l, r) + 1;
    }
}
