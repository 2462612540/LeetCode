package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉树的镜像
 * @Description TODO
 * @Date 2020/12/23 13:35
 * @Created by xjl
 */
public class 二叉树的镜像 {
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

    public void test(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        test(root.left);
        test(root.right);
    }

}
