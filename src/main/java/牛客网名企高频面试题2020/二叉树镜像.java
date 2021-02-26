package 牛客网名企高频面试题2020;

/**
 * @Classname 二叉树镜像
 * @Description TODO
 * @Date 2020/12/17 10:48
 * @Created by xjl
 */
public class 二叉树镜像 {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
