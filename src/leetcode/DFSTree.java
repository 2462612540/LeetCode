/**
 * Copyright (C), 2018-2020
 * FileName: DFSTree
 * Author:   xjl
 * Date:     2020/7/30 9:32
 * Description: 树的递归的遍历
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSTree {
    //树的定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 树的广度优先遍历  层序遍历就是的一中广度遍历的
     *
     * @param root
     */
    public static List<Integer> BFSByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //存放遍历结果，然后返回
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            /*
            处理 TreeNode 节点 的逻辑
             */
            result.add(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }

    /**
     * 先从根节点出发，沿着左子树进行纵向遍历直到找到叶子节点为止。然后回溯到前一个节点，进行右子树节点的遍历，直到遍历完所有可达节点为止。 根左右的遍历
     * @param root
     * @param result
     * @return
     */

    public static List<Integer> DFSByRecursion(TreeNode root, List<Integer> result ) {
        if (root == null) {
            return null;
        }
        result.add(root.val);
        if (root.left != null) {
            DFSByRecursion(root.left, result);
        }
        if (root.right != null) {
            DFSByRecursion(root.right,result);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        TreeNode s6 = new TreeNode(6);

        s1.left = s2;
        s1.right = s3;

        s2.left = s4;
        s3.right = s5;
        s3.left = s6;

        List<Integer> list = DFSByRecursion(s1,new ArrayList<>());
        for (int V:list){
            System.out.print(V+" ");
        }
    }
}
