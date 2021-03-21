package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 二叉树的最大深度
 * @Description TODO
 * @Date 2020/12/23 13:30
 * @Created by xjl
 */
public class 二叉树的最大深度 {

    public int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = test(root.left);
        int right = test(root.right);
        return Math.max(left, right) + 1;
    }

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

}
