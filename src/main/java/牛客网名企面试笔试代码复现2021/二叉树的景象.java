package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname 二叉树的景象
 * @Description TODO
 * @Date 2021/3/8 9:59
 * @Created by xjl
 */
public class 二叉树的景象 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) return root;
        //左边不是空 右边不是空的话的那就返回的是根节点
        if (root.left == null && root.right == null) {
            return root;
        }
        //然后来实现的节点的交换
        TreeNode tmep = root.left;
        root.left = root.right;
        root.right = tmep;
        //分别进行递归的处理子树
        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
