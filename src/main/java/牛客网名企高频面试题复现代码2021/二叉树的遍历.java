package 牛客网名企高频面试题复现代码2021;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 二叉树的遍历
 * @Description TODO
 * @Date 2020/12/23 10:35
 * @Created by xjl
 */
public class 二叉树的遍历 {
    /**
     * @description TODO  前序遍历 根左右  采用的递归的调用的方式
     * @param: root
     * @date: 2020/12/23 10:37
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> before(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        beforeserch(root, ans);
        return ans;
    }

    /**
     * @description TODO  采用的是递归的这样的一种方式
     * @param: root
     * @param: ans
     * @date: 2020/12/23 10:41
     * @return: void
     * @author: xjl
     */
    private void beforeserch(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.left != null) {
            beforeserch(root.left, ans);
        }
        if (root.right != null) {
            beforeserch(root.right, ans);
        }
    }

    /**
     * @description TODO  需要采用的是的非递归的一种方式的
     * @param: root
     * @param: ans
     * @date: 2020/12/23 10:45
     * @return: void
     * @author: xjl
     */
    private List<Integer> beforeserch1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //栈 用于存放树节点
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            //go left down to the ground
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //if we reach to the leaf, go back to the parent right, and repeat the go left down.
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return res;
    }

    /**
     * @description TODO 后序完整代码  左右根
     * @param: root
     * @date: 2020/12/23 12:59
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            TreeNode cur = stack.pop();
            root = cur.left;
        }
        //相当于是的反转前序遍历问题
        Collections.reverse(res);
        return res;
    }

    /**
     * @description TODO  中序完整代码  左根右
     * @param: root
     * @date: 2020/12/23 12:59
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
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

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.left = node6;

        before(root);

    }

    /**
     * @description TODO  树节点的定义
     * @param: null
     * @date: 2020/12/23 10:36
     * @return:
     * @author: xjl
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
