package 计算机程序算法分类.二叉树问题;

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
    /**
     * @description TODO 检查一个树是否对称
     * @param: L
     * @param: R
     * @date: 2021/5/10 20:06
     * @return: boolean
     * @author: xjl
    */
    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
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
