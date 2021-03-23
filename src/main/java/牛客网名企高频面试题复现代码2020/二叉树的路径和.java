package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 二叉树的路径和
 * @Description TODO
 * @Date 2020/12/19 15:23
 * @Created by xjl
 */
public class 二叉树的路径和 {
    int res = Integer.MIN_VALUE;

    public int TreeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMax(root);
        return res;
    }

    /**
     * @description TODO  寻找二叉树的路径和最大数字是多少
     * @param: root
     * @date: 2021/3/23 13:44
     * @return: int
     * @author: xjl
     */
    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = Math.max(0, getMax(root.left));
        int R = Math.max(0, getMax(root.right));
        res = Math.max(res, Math.max(root.val + Math.max(L, R), root.val + R + L));
        return Math.max(L, R) + root.val;
    }
    /**
     * @description TODO  寻找二叉树的最大数字的和 记住二叉树的里面的数字可能有正数 也有可能是的负数 所以 要判断的是的res root.val+L/R L+R+root.val  每一次的返回的L/R+root.val
     * @param: root
     * @date: 2021/3/23 13:47
     * @return: int
     * @author: xjl
    */
    public int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = Math.max(0, sumTree(root.left));
        int R = Math.max(0, sumTree(root.right));
        res = Math.max(res, Math.max(root.val + Math.max(L, R), root.val + R + L));
        return Math.max(L, R) + root.val;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
