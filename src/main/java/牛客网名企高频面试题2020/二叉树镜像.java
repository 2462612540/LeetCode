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
        //二叉树进行的是的左右子树的交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //开始递归的是使用的函数
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
