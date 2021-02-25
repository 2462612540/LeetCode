package 牛客网名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 完全二叉树的节点数
 * @Description TODO
 * @Date 2020/12/15 14:08
 * @Created by xjl
 */
public class 完全二叉树的节点数 {

    /**
     * @description TODO 这样的方式的是的将会是时间复杂度是o(n) 不满足题目的要求
     * @param: head
     * @date: 2020/12/15 14:16
     * @return: int
     * @author: xjl
     */
    public int nodeNum(TreeNode head) {
        if (head == null) return 0;
        int l = nodeNum(head.left);
        int r = nodeNum(head.right);
        return l + r + 1;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);

        int res = nodeNum(root);
        System.out.println(res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
