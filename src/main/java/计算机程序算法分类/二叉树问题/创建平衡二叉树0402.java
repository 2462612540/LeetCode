package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 创建平衡二叉树0402
 * @Description TODO
 * @Date 2021/5/4 14:05
 * @Created by xjl
 */
public class 创建平衡二叉树0402 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        TreeNode root = dfs(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid - 1);
        node.right = dfs(nums, mid + 1, right);
        return node;
    }
}
