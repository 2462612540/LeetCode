package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉搜索树中的搜索700
 * @Description TODO
 * @Date 2021/5/3 12:52
 * @Created by xjl
 */
public class 二叉搜索树中的搜索700 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
    /**
     * @description TODO 写递归的时候需要的主要的是  1返回值 2 递归的条件 3 终止条件
     * @param: root
     * @param: val
     * @date: 2021/5/3 13:11
     * @return: 计算机程序算法分类.二叉树问题.二叉搜索树中的搜索700.TreeNode
     * @author: xjl
    */
    private TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }else if (root.val == val) {
            return root;
        }if (root.val>val){
            return dfs(root.left,val);
        }else {
            return dfs(root.right,val);
        }
    }
}
