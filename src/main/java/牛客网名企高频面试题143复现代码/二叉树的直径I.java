package 牛客网名企高频面试题143复现代码;

/**
 * @Classname 二叉树的直径I
 * @Description TODO
 * @Date 2020/12/13 14:29
 * @Created by xjl
 */
public class 二叉树的直径I {
    int ans = 1;

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return ans - 1;
    }

    private int rootdepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = rootdepth(root.left);
        int R = rootdepth(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
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
