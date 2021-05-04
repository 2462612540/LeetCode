package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 单值二叉树965
 * @Description TODO
 * @Date 2021/5/4 10:02
 * @Created by xjl
 */
public class 单值二叉树965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }

    List<Integer> vals;
    public boolean isUnivalTree2(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
