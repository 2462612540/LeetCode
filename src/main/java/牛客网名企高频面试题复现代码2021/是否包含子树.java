package 牛客网名企高频面试题复现代码2021;

/**
 * @Classname 是否包含子树
 * @Description TODO
 * @Date 2020/12/12 17:36
 * @Created by xjl
 */
public class 是否包含子树 {

    public boolean isContains(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return isContains(root1.left, root2) || isContains(root1.right, root2) || issameTree(root1, root2);
    }

    public boolean issameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return issameTree(root1.left, root2.left) && issameTree(root1.right, root2.right);
    }

    public boolean subtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return subtree(root1.left, root2) || subtree(root1.right, root2) || samTree(root1, root2);
    }

    private boolean samTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return samTree(root1.left, root2.left) && samTree(root1.right, root2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
