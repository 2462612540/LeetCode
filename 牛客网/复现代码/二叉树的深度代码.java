package 复现代码;

/**
 * @Classname 二叉树的深度代码
 * @Description TODO
 * @Date 2020/12/9 18:36
 * @Created by xjl
 */
public class 二叉树的深度代码 {
    public int deepth(TreeeNode root) {
        if (root == null) {
            return 0;
        }
        int res = detepth(root);
        return res;

    }

    private int detepth(TreeeNode root) {
        if (root == null) {
            return 0;
        }
        int L = deepth(root.left);
        int R = deepth(root.right);
        return Math.max(L, R) + 1;
    }

    public class TreeeNode {
        int val;
        TreeeNode left;
        TreeeNode right;

        public TreeeNode(int val) {
            this.val = val;
        }
    }

}
