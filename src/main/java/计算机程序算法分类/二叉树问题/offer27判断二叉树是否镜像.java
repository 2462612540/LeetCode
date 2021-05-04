package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 判断二叉树是否镜像offer27
 * @Description TODO
 * @Date 2021/5/4 15:26
 * @Created by xjl
 */
public class offer27判断二叉树是否镜像 {
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

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
