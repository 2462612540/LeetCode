package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉树的节点个数222
 * @Description TODO
 * @Date 2021/5/6 16:11
 * @Created by xjl
 */
public class 二叉树的节点个数222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * @description TODO 求解的二叉树的节点的个数
     * @param: root
     * @date: 2021/5/6 16:13
     * @return: int
     * @author: xjl
    */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l + r + 1;
    }
}
