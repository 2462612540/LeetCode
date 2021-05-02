package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

/**
 * @Classname 有序数组转变二叉搜索树108
 * @Description TODO
 * @Date 2021/4/30 14:09
 * @Created by xjl
 */
public class 有序数组转变二叉搜索树108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBSTTest(int[] nums) {
        return buidtree(nums, 0, nums.length - 1);
    }

    private TreeNode buidtree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buidtree(nums, left, mid - 1);
        node.right = buidtree(nums, mid + 1, right);
        return node;
    }

}
