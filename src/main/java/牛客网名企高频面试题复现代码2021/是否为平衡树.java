package 牛客网名企高频面试题复现代码2021;

/**
 * @Classname 是否为平衡树
 * @Description TODO
 * @Date 2020/12/23 13:12
 * @Created by xjl
 */
public class 是否为平衡树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return test(root) != -1;
    }

    private int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = test(root.left);
        if (left == -1) {
            return -1;
        }
        int right = test(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
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
