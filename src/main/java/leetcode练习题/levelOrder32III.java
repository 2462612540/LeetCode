/**
 * Copyright (C), 2018-2020
 * FileName: levelOrder32III
 * Author:   xjl
 * Date:     2020/8/20 18:28
 * Description: 层序遍历
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32III {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        //保存每一层的节点的数量个数
        int sum = 1;
        //用来控制左边还是右边的输入的
        int num = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int temp = 0;//保存当前层的下一层的节点
            while (sum > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    temp++;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    temp++;
                    queue.add(node.right);
                }
                sum--;
            }
            sum = temp;
            //如果是的等于偶数的话那就是的需要将数据的翻转过来的
            if (num % 2 == 0) {
                for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
    }

}
