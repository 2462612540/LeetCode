package 牛客网名企高频面试题复现代码;

/**
 * @Classname 二叉树的直径
 * @Description TODO
 * @Date 2020/12/8 16:09
 * @Created by xjl
 */
public class 二叉树的直径 {
    //表示二叉数据的直径 表示的是如果存在话至少1的
    int dis = 1;

    /**
     * @description TODO 表示的是的二叉树的直径
     * @param: root
     * @date: 2020/12/8 16:10
     * @return: int
     * @author: xjl
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        deepth(root);
        return dis - 1;
    }

    private int deepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deepth(root.left);
        int right = deepth(root.right);
        dis = Math.max(dis, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int dmax = 1;

    public int dTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        deepth1(root);
        return dmax - 1;
    }

    private int deepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = deepth1(root.left);
        int R = deepth1(root.right);
        dmax = Math.max(dmax, L + R + 1);
        return Math.max(L, R) + 1;
    }

}
