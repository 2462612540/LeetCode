package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二叉树的遍历的打印
 * Author:   xjl
 * Date:     2020/9/13 21:26
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的遍历的打印 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历是根左右
     *
     * @param root
     * @return
     */
    public List<Integer> before(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        beforeserch(root, ans);
        return ans;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @param list
     */
    private void beforeserch(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //根
        list.add(root.val);
        //左
        if (root.left != null) {
            beforeserch(root.left, list);
        }
        //右
        if (root.right != null) {
            beforeserch(root.right, list);
        }
    }

    /**
     * 中序遍历是左根右
     *
     * @param root
     * @return
     */
    public List<Integer> mid(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        midserch(root, ans);
        return ans;
    }

    /**
     * 中序遍历 左根右
     *
     * @param root
     * @param list
     */
    private void midserch(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //左
        if (root.left != null) {
            midserch(root.left, list);
        }
        //根
        list.add(root.val);
        //右
        if (root.right != null) {
            midserch(root.right, list);
        }
    }

    /**
     * 后序遍历是左右根
     *
     * @param root
     * @return
     */
    public List<Integer> after(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        afterserch(root, ans);
        return ans;
    }

    /**
     * 后序遍历 左右根
     *
     * @param root
     * @param list
     */
    private void afterserch(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        //左
        if (root.left != null) {
            afterserch(root.left, list);
        }
        //右
        if (root.right != null) {
            afterserch(root.right, list);
        }
        //根
        list.add(root.val);
    }

    @Test
    public void test() {
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        s1.left = s2;
        s1.right = s3;
        int[] before = before(s1).stream().mapToInt(Integer::valueOf).toArray();
        int[] mid = mid(s1).stream().mapToInt(Integer::valueOf).toArray();
        int[] after = after(s1).stream().mapToInt(Integer::valueOf).toArray();
        int[][] ans = {before, mid, after};
    }
}
