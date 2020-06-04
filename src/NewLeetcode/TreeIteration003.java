/**
 * Copyright (C), 2018-2020
 * FileName: TreeIteration003
 * Author:   xjl
 * Date:     2020/6/4 11:12
 * Description: 树的四种遍历方式
 */
package NewLeetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的四种遍历的代码
 */
public class TreeIteration003 {

    //先序遍历的结果
    public List<String> before(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //调用前序遍历的函数
        before(root, list);
        return list;
    }

    //前序遍历是根左右
    public void before(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        //根
        list.add(root.val);
        if (root.left != null) {
            //左子树
            before(root.left, list);
        }
        if (root.right != null) {
            //右子树
            before(root.right, list);
        }
    }

    //先序遍历的结果
    public List<String> mid(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //调用中序遍历的函数
        mid(root, list);
        return list;
    }

    //中序遍历是左根右
    public void mid(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            mid(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            mid(root.right, list);
        }
    }

    //后序遍历
    public List<String> after(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //调用中序遍历的函数
        after(root, list);
        return list;
    }

    //后序遍历
    public void after(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            after(root.left, list);
        }
        if (root.right != null) {
            after(root.right, list);
        }
        list.add(root.val);
    }

    //层序遍历
    public List<String> ceng(TreeNode root) {
        if (root == null) return null;
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = ((LinkedList<TreeNode>) queue).pop();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode s1 = new TreeNode("A");
        TreeNode s2 = new TreeNode("B");
        TreeNode s3 = new TreeNode("C");
        TreeNode s4 = new TreeNode("D");
        TreeNode s5 = new TreeNode("E");
        TreeNode s6 = new TreeNode("F");
        TreeNode s7 = new TreeNode("G");
        TreeNode s8 = new TreeNode("H");

        s1.left = s2;
        s1.right = s3;

        s2.left = s4;
        s2.right = s5;

        s3.right = s6;

        s5.left = s7;
        s5.right = s8;

        List<String> list = before(s1);
        for (String v : list) {
            System.out.print(v + " ");
        }
        System.out.println();
        List<String> list1 = mid(s1);
        for (String v : list1) {
            System.out.print(v + " ");
        }
        System.out.println();
        List<String> list2 = after(s1);
        for (String v : list2) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println("---------------------------");
        List<String> list3 = ceng(s1);
        for (String v : list3) {
            System.out.print(v + " ");
        }
    }

    public class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String x) {
            val = x;
        }
    }
}
