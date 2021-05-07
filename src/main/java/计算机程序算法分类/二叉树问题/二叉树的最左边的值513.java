package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 二叉树的最左边的值513
 * @Description TODO
 * @Date 2021/5/7 14:30
 * @Created by xjl
 */
public class 二叉树的最左边的值513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO  给定一个二叉树，在树的最后一行找到最左边的值。 其实也是一个层序遍历的算法
     * @param: null
     * @date: 2021/5/7 14:31
     * @return:
     * @author: xjl
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1).get(0);
    }

    private int curMaxDepth = -1, curVal = 0;

    public int findBottomLeftValue2(TreeNode root) {
        help(root, 0);
        return curVal;
    }

    private void help(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > curMaxDepth) {
            curMaxDepth = depth;
            curVal = root.val;
        }
        help(root.left, depth + 1);
        help(root.right, depth + 1);
    }
}
