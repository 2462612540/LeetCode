package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.判断二叉树的是否为的搜索二叉树和完全二叉树
 * Author:   xjl
 * Date:     2020/10/1 15:30
 * Description:
 */


import java.util.LinkedList;

/**
 * // 两个情况分别判断：
 * // 二叉搜索树：每个节点左边节点小于右边节点，左子树的最大值一定小于根节点，小于右子树的最大值；通过中序遍历，严格递增
 * <p>
 * // 完全二叉树：层序遍历，除了最后的一层，每层都是满的
 */
public class 判断二叉树的是否为的搜索二叉树和完全二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean[] judgeIt(TreeNode root) {
        boolean[] res = new boolean[2];
        res[0] = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        res[1] = isComplete(root);
        return res;
    }

    /**
     * 二叉树搜索树， 左节点小于根节点  右节点大于根节点
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    /**
     * 完全二叉树 一个节点 有左节点才能有右节点，如果 一个节点的子节点为空则下一level的这个子节点的右侧没有节点
     *
     * @param node
     * @return
     */
    public boolean isComplete(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                break;
            }
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {

                return false;
            }
        }
        return true;
    }
}
