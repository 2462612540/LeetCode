/**
 * Copyright (C), 2018-2020
 * FileName: sortedArrayToBST108
 * Author:   xjl
 * Date:     2020/7/3 9:03
 * Description: 108. 将有序数组转换为二叉搜索树
 */
package leetcode练习题;

public class sortedArrayToBST108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        TreeNode root = help(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = help(nums, left, mid - 1);
        current.right = help(nums, mid + 1, right);
        return current;
    }

}
