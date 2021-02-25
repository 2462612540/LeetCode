/**
 * Copyright (C), 2018-2020
 * FileName: Solution
 * Author:   xjl
 * Date:     2020/5/9 9:19
 * Description:  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.*;

public class Solution {

    public Stack<Integer> stack = new Stack();

    public void push(int node) {
        stack.add(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        List<Integer> list = new ArrayList<>();
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            list.add((Integer) iterator.next());
        }
        return Collections.min(list);
    }

    public int min2() {
        List<Integer> list = new ArrayList<>();
        while (stack.empty() == false) {
            list.add(stack.peek());
            stack.pop();
        }
        return Collections.min(list);
    }

    @Test
    public void test() {
        push(3);
        push(4);
        push(5);
        push(8);
        push(1);
        push(10);

        int res = min2();
        System.out.println(res);
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert1(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode left = Convert(root.left);
        TreeNode p = left;

        while (p != null && p.right != null) {
            p = p.right;
        }

        if (left != null) {
            p.right = root;
            root.left = p;
        }

        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }

        return left != null ? left : root;
    }

    //采用的中序遍历来实现
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        ConvertSub(pRootOfTree.left);

        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }

    @Test
    public void test5() {
        TreeNode s1 = new TreeNode(7);
        TreeNode s2 = new TreeNode(3);
        TreeNode s3 = new TreeNode(10);
        TreeNode s4 = new TreeNode(1);
        TreeNode s5 = new TreeNode(5);
        TreeNode s6 = new TreeNode(9);
        TreeNode s7 = new TreeNode(12);

        s1.left = s2;
        s1.right = s3;

        s2.left = s4;
        s2.right = s5;

        s3.left = s6;
        s3.right = s7;

        TreeNode node = Convert2(s1);
    }

    public TreeNode Convert2(TreeNode pRootOfTree) {

        List<TreeNode> list = new ArrayList<>();
        //中序遍历
        Convertsub2(pRootOfTree, list);
        if (list.size() == 1) {
            list.get(0).right = list.get(0);
            list.get(0).left = list.get(0);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).right = list.get(i + 1);
                list.get(i).left = null;
            } else if (i == list.size() - 1) {
                list.get(i).right = null;
                list.get(i).left = list.get(i - 1);
            } else {
                list.get(i).right = list.get(i + 1);
                list.get(i).left = list.get(i - 1);
            }
        }
        pRootOfTree = list.get(0);
        while (pRootOfTree != null) {
            System.out.println(pRootOfTree.val);
            pRootOfTree = pRootOfTree.right;
        }
        return pRootOfTree;
    }

    public void Convertsub2(TreeNode pRootOfTree, List list) {
        if (pRootOfTree == null) {
            return;
        }
        if (pRootOfTree.left != null) {
            Convertsub2(pRootOfTree.left, list);
        }
        list.add(pRootOfTree);
        if (pRootOfTree.right != null) {
            Convertsub2(pRootOfTree.right, list);
        }
    }

}
