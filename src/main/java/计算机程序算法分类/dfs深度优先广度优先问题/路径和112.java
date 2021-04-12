package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * @description TODO 这个是的采用的是dfs也就是的递归的思想来实现 这个其实就是的二叉树的遍历方式不过是加了一个判断的额条件就是的是否为叶子结点且值是否等于的节点
     * @param: root
     * @param: targetSum
     * @date: 2021/4/12 16:38
     * @return: boolean
     * @author: xjl
     */
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

    /**
     * @description TODO  采用的是广度遍历的方式来实现 每一次查看给节点是叶子节点且同时这个目标的值等于弹出的值如果是的话那就到了叶子节点
     * @param: root
     * @param: targetSum
     * @date: 2021/4/12 16:32
     * @return: boolean
     * @author: xjl
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //用于存放的二叉树的节点
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        //存放数值
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            //弹出节点的值
            TreeNode now = queNode.poll();
            //弹出这个值得结果
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            //遍历左边
            if (now.left != null) {
                //添加这个左节点
                queNode.offer(now.left);
                //向值里面添加
                queVal.offer(now.left.val + temp);
            }

            //遍历右边
            if (now.right != null) {
                //添加右边的节点
                queNode.offer(now.right);
                //向值里面添加
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

}
