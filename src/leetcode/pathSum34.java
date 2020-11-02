/**
 * Copyright (C), 2018-2020
 * FileName: pathSum34
 * Author:   xjl
 * Date:     2020/6/10 11:07
 * Description: 面试题34. 二叉树中和为某一值的路径
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class pathSum34 {

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(root, sum, 0, list);
        return result;
    }

    /**
     * @param node   二叉树的节点
     * @param sum    当前路径的权值和
     * @param target 目标的权值的和
     * @param list   保存路径
     */
    private void slove(TreeNode node, int target, int sum, List<Integer> list) {
        if (node != null) {
            //先把这个值加到里面来实现
            sum += node.val;
            list.add(node.val);
            //判断是否到了根节点
            if (node.left == null && node.right == null) {
                if (sum == target) {
                    //复制新的节点
                    ArrayList<Integer> res = new ArrayList<>(list);
                    result.add(res);
                }
            } else {
                //左子树递归
                slove(node.left, target, sum, list);
                //右子树递归
                slove(node.right, target, sum, list);
            }
            //消除当前的节点的查找的路径的影响
            sum -= node.val;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> findpath(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        find(root, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private void find(TreeNode node, int sum, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        //递归终止的条件是
        if (node == null && sum == target && !result.contains(list)) {
            result.add(list);
            return;
        }
        if (node == null) {
            return;
        }
        //业务处理
        sum += node.val;
        list.add(node.val);
        if (sum > target) {
            return;
        }
        find(node.left, target, sum, new ArrayList<>(list), result);
        find(node.right, target, sum, new ArrayList<>(list), result);

    }

    @Test
    public void test() {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
