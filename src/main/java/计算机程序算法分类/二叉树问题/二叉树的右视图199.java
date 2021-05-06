package 计算机程序算法分类.二叉树问题;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 二叉树的右视图199
 * @Description TODO
 * @Date 2021/5/6 15:10
 * @Created by xjl
 */
public class 二叉树的右视图199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO 这个就二叉的层序遍历 然后选择最后的一个的结果
     * @param: root
     * @date: 2021/5/6 15:11
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(ans.get(ans.size() - 1));
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.right = node5;
        node3.right = node4;

        List<Integer> list = rightSideView(root);
        System.out.println(list.toArray().toString());
    }

}
