package 计算机程序算法分类.二叉树问题;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname 奇偶树1609
 * @Description TODO
 * @Date 2021/5/10 9:20
 * @Created by xjl
 */
public class 奇偶树1609 {
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
     * @description TODO 其实这也是一个的层序遍历的方法
     * @param: root
     * @date: 2021/5/10 9:22
     * @return: boolean
     * @author: xjl
     */
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            lists.add(list);
        }
        if (lists.get(0).get(0) % 2 == 0) {
            return false;
        }
        //这里来同一判断
        for (int i = 1; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                if (i % 2 != 0) {
                    if (lists.get(i).get(j) % 2 != 0) {
                        return false;
                    }
                    if (j + 1 < lists.get(i).size() && (lists.get(i).get(j) % 2 != 0 || lists.get(i).get(j) - lists.get(i).get(j + 1) < 0 || lists.get(i).get(j).equals(lists.get(i).get(j + 1)))) {
                        return false;
                    }
                } else {
                    if (lists.get(i).get(j) % 2 == 0) {
                        return false;
                    }
                    if (j + 1 < lists.get(i).size() && (lists.get(i).get(j) % 2 == 0 || lists.get(i).get(j) - lists.get(i).get(j + 1) > 0 || lists.get(i).get(j).equals(lists.get(i).get(j + 1)))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
