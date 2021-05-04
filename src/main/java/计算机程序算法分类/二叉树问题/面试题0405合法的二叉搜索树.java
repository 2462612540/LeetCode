package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname 面试题0405合法的二叉搜索树
 * @Description TODO
 * @Date 2021/5/4 16:04
 * @Created by xjl
 */
public class 面试题0405合法的二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    boolean ans = true;

    public boolean isValidBST2(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        if (root == null) {
            return false;
        }
        dfs2(root, stack);
        return ans;
    }

    private void dfs2(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        dfs2(root.left, stack);
        if (stack.isEmpty()){
            stack.add(root.val);
        }else {
            if (root.val <= stack.peek()) {
                ans = false;
                return;
            }
        }
        stack.add(root.val);
        dfs2(root.right, stack);
    }

    TreeNode prev;
    public boolean isValidBST3(TreeNode root) {
        if (root == null)
            return true;
        //访问左子树
        if (!isValidBST3(root.left))
            return false;
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
        if (prev != null && prev.val >= root.val)
            return false;
        //然后记录这个的根节点
        prev = root;
        //访问右子树
        if (!isValidBST3(root.right))
            return false;
        return true;
    }
}
