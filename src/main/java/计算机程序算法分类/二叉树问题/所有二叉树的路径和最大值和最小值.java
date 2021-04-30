package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 所有二叉树的路径和最大值和最小值
 * @Description TODO
 * @Date 2021/4/29 20:53
 * @Created by xjl
 */
public class 所有二叉树的路径和最大值和最小值 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int min = Integer.MIN_VALUE;//如果是小值 复制的时候初值的就是的MIN_VALUE 但是如是最大值的MAX_VALUE

    public static int minsum(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            new Exception("树为空");
        }
        dfs(root, 0);
        return min;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        //当前和加上根节点的值
        sum += root.val;
        if (root.left == null && root.right == null) {
            min = Math.max(min, sum);
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }
}
