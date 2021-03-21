package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname BST
 * @Description TODO
 * @Date 2020/12/13 14:56
 * @Created by xjl
 */
public class BST {
    public TreeNode sortArrayBST(int[] nums) {
        if (nums.length == 0) return null;
        return builder(nums, 0, nums.length - 1);
    }

    private TreeNode builder(int[] nums, int start, int end) {
        //终止条件
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        //实际上这个+1都是可以的。最后的都是一个二叉树
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = builder(nums, start, mid - 1);
        root.right = builder(nums, mid + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
