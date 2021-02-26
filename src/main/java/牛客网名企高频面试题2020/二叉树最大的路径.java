package 牛客网名企高频面试题2020;

/**
 * @Classname 二叉树最大的路径
 * @Description TODO
 * @Date 2020/12/19 14:49
 * @Created by xjl
 */
public class 二叉树最大的路径 {
    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左边树的最大值
        int leftMax = Math.max(0, getMax(root.left));
        //右边树的最大值
        int rightMax = Math.max(0, getMax(root.right));
        //*1.--下面一行划重点--//
        res = Math.max(res, Math.max(root.val + Math.max(leftMax, rightMax), root.val + leftMax + rightMax));
        //返回上一行的结果
        return Math.max(leftMax, rightMax) + root.val;
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
