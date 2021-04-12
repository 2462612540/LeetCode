package 计算机程序算法分类.dfs深度优先广度优先问题;

/**
 * @Classname 路径和112
 * @Description TODO
 * @Date 2021/4/11 18:21
 * @Created by xjl
 */
public class 路径和112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //采用的递归的遍历的思想来实现的这个原理的
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            }
        }
        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        //只有左边或者右边都是有一个就行
        return l || r;
    }


}
