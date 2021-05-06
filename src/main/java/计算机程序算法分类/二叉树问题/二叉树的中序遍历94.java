package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二叉树的中序遍历94
 * @Description TODO
 * @Date 2021/5/6 14:03
 * @Created by xjl
 */
public class 二叉树的中序遍历94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //左更右
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private void dfs2(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //左更右
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    private void dfs3(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //左更右
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}
