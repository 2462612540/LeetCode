package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 二叉树的根部叶子节点的所表示的值的和
 * Author:   xjl
 * Date:     2020/10/5 20:50
 * Description:
 */


import org.junit.Test;

public class 二叉树的路径和 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        test11(root, "");
        return sum;
    }

    //采用的是的DFS的遍历思想 在将每一个值表示的 在加起来
    private void test11(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s += String.valueOf(root.val);
            sum += Integer.valueOf(s);
            return;
        }
        s += String.valueOf(root.val);
        if (root.left != null) {
            test11(root.left, s);
        }
        if (root.right != null) {
            test11(root.right, s);
        }
    }

    @Test
    public void test() {
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);

        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);

        TreeNode s6 = new TreeNode(6);

        s1.left = s2;
        s1.right = s3;
        s2.left = s4;
        s2.right = s5;

        s3.right = s6;

        int ans = sumNumbers(s1);
        System.out.println(ans);
    }
}
