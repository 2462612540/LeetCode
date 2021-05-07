package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 最大二叉树654
 * @Description TODO
 * @Date 2021/5/7 15:55
 * @Created by xjl
 */
public class 最大二叉树654 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length < 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int max = findmax(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        root.left = dfs(nums, left, max);
        root.right = dfs(nums, max + 1, right);
        return root;
    }

    public int findmax(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i]){
                max_i = i;
            }
        }
        return max_i;
    }

}
