/**
 * Copyright (C), 2018-2020
 * FileName: Tree_length
 * Author:   xjl
 * Date:     2020/8/8 10:48
 * Description: 最远的距离
 */
package leetcode练习题;

public class Tree_length {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int va) {
            this.val = va;
        }
    }

    public static void main(String[] args) {
        //构造一个树
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        TreeNode s6 = new TreeNode(6);
        TreeNode s7 = new TreeNode(7);
        TreeNode s8 = new TreeNode(8);
        TreeNode s9 = new TreeNode(9);

        s1.left = s2;
        s1.right = s3;

        s2 = s4;

        s3.left = s5;
        s3.right = s6;

        s5.left = s7;

        s6.left = s8;
        s6.right = s9;

        //调用函数

        int length = diameterOfBinaryTree(s1);

        System.out.println(length);

        //结果
    }

    private static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        ans = 1;
        depth(root);
        return ans ;
    }

    public static int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
