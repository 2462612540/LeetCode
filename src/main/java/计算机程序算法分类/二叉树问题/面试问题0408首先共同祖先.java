package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 面试问题0408首先共同祖先
 * @Description TODO
 * @Date 2021/5/4 16:45
 * @Created by xjl
 */
public class 面试问题0408首先共同祖先 {
    /**
     * @description TODO  树节点的定义
     * @param: null
     * @date: 2020/12/23 10:36
     * @return:
     * @author: xjl
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //首先要检查当前的root情况，若为null就直接返回；
        //若为p、q则是满足最近公共节点为节点本身
        if (root == null || root == p || root == q)
            return root;
        //再利用递归从根节点开始，开始向下遍历每个节点（以下两步则为具体对每一个节点的左右子树查找），由上述if语句的返回值得到这两个节点的值
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        //对于left和right节点返回的情况，如果根节点的左子树/右子树找不到最近公共节点，那么就说明在右子树/左子树当中
        if (left == null)
            return right;

        if (right == null)
            return left;
        //如果上述两个情况都不符合 则说明根节点就是最近公共节点，直接返回
        return root;
    }
}
