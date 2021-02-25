package 牛客网名企高频面试题143;

/**
 * @Classname 是否包含子树
 * @Description TODO
 * @Date 2020/12/12 16:51
 * @Created by xjl
 */
public class 是否包含子树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @description TODO 给定彼此独立的两棵二叉树，判断 t1 树是否有与 t2 树拓扑结构完全相同的子树。
     * @param: root1
     * @param: root2
     * @date: 2020/12/12 16:53
     * @return: boolean
     * @author: xjl
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;   // t 为 null 一定都是 true
        if (root1 == null) return false;
        return isContains(root1.left, root2) || isContains(root1.right, root2) || isSameTree(root1, root2);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
