package 牛客网名企高频面试题143;

/**
 * @Classname 对称二叉树
 * @Description TODO
 * @Date 2020/12/17 10:26
 * @Created by xjl
 */
public class 对称二叉树 {
    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
