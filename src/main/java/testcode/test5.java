package testcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname test5
 * @Description TODO
 * @Date 2021/4/29 17:07
 * @Created by xjl
 */
public class test5 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int min=Integer.MIN_VALUE;

    public static int minsum(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            new Exception("树为空");
        }
        dfs(root, 0);
        return min;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            min=Math.max(min,sum);
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

//        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
//        node2.right = node6;

        int i = minsum(root);
        System.out.println(i);

    }
}
