/**
 * Copyright (C), 2018-2020
 * FileName: isBalanced
 * Author:   xjl
 * Date:     2020/8/14 16:19
 * Description: 是否为平衡树
 */
package Tree;

public class isBalanced {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param root
     * @return
     */
    private int recur(TreeNode root) {
        //递归终止条件
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        //判断是否为左和右边的节点数据超过的2
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
