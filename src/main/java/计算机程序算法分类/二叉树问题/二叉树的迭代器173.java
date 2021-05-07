package 计算机程序算法分类.二叉树问题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname 二叉树的迭代器173
 * @Description TODO
 * @Date 2021/5/7 9:53
 * @Created by xjl
 */
public class 二叉树的迭代器173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Queue<Integer> queue = new LinkedList<>();

    public 二叉树的迭代器173(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        queue.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.isEmpty();
    }
}
