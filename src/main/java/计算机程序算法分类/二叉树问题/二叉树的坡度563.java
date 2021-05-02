package 计算机程序算法分类.二叉树问题;

import org.junit.Test;

/**
 * @Classname 二叉树的坡度563
 * @Description TODO
 * @Date 2021/5/2 10:55
 * @Created by xjl
 */
public class 二叉树的坡度563 {
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

    /**
     * @description TODO 求解的是所有的左右的子树的和
     * @param: root
     * @date: 2021/5/2 10:56
     * @return: int
     * @author: xjl
     */
    int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return sum;
    }

    //求解的是左子树和右子树的差值
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        sum += Math.abs(l - r);
        return l + r + root.val;//返回的是的左右的子树的和加上本身的值
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        int tilt = findTilt(root);
        System.out.println(tilt);

    }

}
