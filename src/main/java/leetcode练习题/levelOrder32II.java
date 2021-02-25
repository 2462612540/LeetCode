/**
 * Copyright (C), 2018-2020
 * FileName: levelOrder32II
 * Author:   xjl
 * Date:     2020/8/20 18:25
 * Description: 层序遍历的2
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //存放结果的
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1;
        while (!queue.isEmpty() && root != null) {
            List<Integer> list = new LinkedList<>();
            int temp = 0;
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
            ans.add(list);
        }
        return ans;
    }
}
