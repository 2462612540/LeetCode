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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return true;
    }
}
