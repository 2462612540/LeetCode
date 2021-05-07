package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname 在每个树行中找最大值515
 * @Description TODO
 * @Date 2021/5/7 14:56
 * @Created by xjl
 */
public class 在每个树行中找最大值515 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> node = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        node.add(root);

        while (!node.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = node.size();
            for (int i = 0; i < size; i++) {
                TreeNode node1 = node.poll();
                max=Math.max(max,node1.val);
                if (node1.left!=null){
                    node.add(node1.left);
                }
                if (node1.right!=null){
                    node.add(node1.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
