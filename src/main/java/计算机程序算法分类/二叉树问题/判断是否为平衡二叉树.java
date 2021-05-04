package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 判断是否为平衡二叉树
 * @Description TODO
 * @Date 2021/5/4 11:27
 * @Created by xjl
 */
public class 判断是否为平衡二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }
}
