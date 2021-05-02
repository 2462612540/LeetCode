package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 翻转二叉树
 * @Description TODO
 * @Date 2021/4/30 14:22
 * @Created by xjl
 */
public class 翻转二叉树226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //二叉树的翻转
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
