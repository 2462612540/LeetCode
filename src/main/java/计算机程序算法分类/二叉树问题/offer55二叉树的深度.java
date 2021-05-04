package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉树的深度offer55
 * @Description TODO
 * @Date 2021/5/4 15:32
 * @Created by xjl
 */
public class offer55二叉树的深度 {

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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        return Math.max(l, r) + 1;
    }
}
