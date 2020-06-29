/**
 * Copyright (C), 2018-2020
 * FileName: getAllElements1305
 * Author:   xjl
 * Date:     2020/6/28 10:32
 * Description: 两棵二叉搜索树中的所有元素
 */
package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class getAllElements1305 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //遍历函数
        Before(root1, list);
        Before(root2, list);
        Collections.sort(list);
        return list;
    }

    private void Before(TreeNode root1, List<Integer> list) {
        if (root1 == null) {
            return;
        }
        // 前序遍历
        list.add(root1.val);
        Before(root1.left, list);
        Before(root1.right, list);
    }

    @Test
    public void test() {
        TreeNode s1 = new TreeNode(2);
        TreeNode s2 = new TreeNode(1);
        TreeNode s3 = new TreeNode(4);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);

        s1.left = s2;
        s1.right = s3;

        n1.left = n2;
        n1.right = n3;

        List<Integer> allElements = getAllElements(s1, n1);
        for (int V : list) {
            System.out.print(V + " ");
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
