package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 二叉树是否对称
 * @Description TODO
 * @Date 2020/12/23 13:39
 * @Created by xjl
 */
public class 二叉树是否对称 {

    /**
     * @description TODO  是否为对称二叉树
     * @param: root
     * @date: 2020/12/23 13:40
     * @return: boolean
     * @author: xjl
     */
    public boolean test(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public boolean recur(TreeNode root) {
        if (root == null) {
            return false;
        }
        return testrecur(root.left, root.right);

    }

    private boolean testrecur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        //如果下面有一个条件是满足的话那就是表示这个是一个不是对称的树
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //分别去判断的两个子树的
        return testrecur(left.left, left.right) && testrecur(right.left, right.right);
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
