package 计算机程序算法分类.二叉树问题;

import java.util.*;

/**
 * @Classname 二叉树的层序遍历II
 * @Description TODO
 * @Date 2021/5/6 14:28
 * @Created by xjl
 */
public class 二叉树的层序遍历II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO 打印之子形状的结果
     * @param: root
     * @date: 2021/5/6 14:29
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @author: xjl
     */
    public List<List<Integer>> levelOrdertest(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (index%2==0){
                //将list 翻转
                Collections.reverse(list);
            }
            lists.add(list);
            index++;
        }
        return lists;
    }
}
