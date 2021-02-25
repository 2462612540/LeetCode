package 牛客网名企高频面试题;

/**
 * @Classname 二叉树的深度
 * @Description TODO
 * @Date 2020/12/8 16:18
 * @Created by xjl
 */
public class 二叉树的深度 {
    public int Treedeepth(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        return deepth(Node);
    }

    private int deepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = deepth(node.left);
        int R = deepth(node.right);
        return Math.max(L, R) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
