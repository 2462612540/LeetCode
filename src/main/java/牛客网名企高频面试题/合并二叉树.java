package 牛客网名企高频面试题;

/**
 * @Classname 合并二叉树
 * @Description TODO
 * @Date 2020/12/13 20:32
 * @Created by xjl
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        t1.val = t1.val + t2.val;
        if (t1.left != null && t2.left != null) {
            mergeTrees(t1.left, t2.left);
        } else if (t1.left == null && t2.left != null) {
            t1.left = t2.left;
        }
        if (t1.right != null && t2.right != null) {
            mergeTrees(t1.right, t2.right);
        } else if (t1.right == null && t2.right != null) {
            t1.right = t2.right;
        }
        return t1;
    }

    /**
     * @description TODO 代码的复现代码
     * @param: t1
     * @param: t2
     * @date: 2020/12/13 21:01
     * @return: 名企高频面试题143.合并二叉树.TreeNode
     * @author: xjl
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        t1.val += t2.val;
        if (t1.left != null && t2.left != null) {
            mergeTrees(t1.left, t2.left);
        } else if (t1.left == null && t2.left != null) {
            t1.left = t2.left;
        }
        if (t1.right != null && t2.right != null) {
            mergeTrees(t1.right, t2.right);
        } else if (t1.right == null && t2.right != null) {
            t1.right = t2.right;
        }
        return t1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
