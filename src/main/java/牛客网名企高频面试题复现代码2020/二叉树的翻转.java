package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 二叉树的镜像
 * @Description TODO
 * @Date 2020/12/23 13:35
 * @Created by xjl
 */
public class 二叉树的翻转 {

    public void test(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        test(root.left);
        test(root.right);
    }

    /**
     * @description TODO 二叉树的翻转
     * @param: root
     * @date: 2021/3/23 13:42
     * @return: void
     * @author: xjl
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        //翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归调用
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * @description TODO  判断二叉树的时候的对称
     * @param: L
     * @param: R
     * @date: 2021/3/23 13:42
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
     * @description TODO 二叉树的翻转
     * @param: Root
     * @date: 2021/3/23 13:43
     * @return: 牛客网名企高频面试题复现代码2020.二叉树的翻转.TreeNode
     * @author: xjl
     */
    public TreeNode Mirror(TreeNode Root) {
        if (Root == null) return Root;
        if (Root.left == null && Root.right == null) {
            return Root;
        }
        //处理根节点，交换左右节点
        TreeNode temp = Root.left;
        Root.left = Root.right;
        Root.right = temp;
        //处理左子树
        Mirror(Root.left);
        //处理右子树
        Mirror(Root.right);
        return Root;
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
