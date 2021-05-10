package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉搜索树的转为双链表
 * @Description TODO
 * @Date 2021/5/10 19:31
 * @Created by xjl
 */
public class 二叉搜索树的转为双链表 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre, head;
    /**
     * @description TODO  本文解法基于性质：二叉搜索树的中序遍历为 递增序列 。
      * @param: root
     * @date: 2021/5/10 19:37
     * @return: 计算机程序算法分类.二叉树问题.二叉搜索树的转为双链表.Node
     * @author: xjl
    */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
