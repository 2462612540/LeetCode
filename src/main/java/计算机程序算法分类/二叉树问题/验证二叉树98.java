package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 验证二叉树98
 * @Description TODO
 * @Date 2021/5/4 17:09
 * @Created by xjl
 */
public class 验证二叉树98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        //访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        //然后记录这个的根节点
        prev = root;
        //访问右子树
        if (!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
