package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Classname 二叉树中第二小的节点
 * @Description TODO
 * @Date 2021/5/3 10:41
 * @Created by xjl
 */
public class 二叉树中第二小的节点 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO 第一种的方式的是的数据遍历 后在进行的排序 但是不符合最优解
     * @param: root
     * @date: 2021/5/3 10:42
     * @return: int
     * @author: xjl
     */
    public int findSecondMinimumValue2(TreeNode root) {
        TreeSet<Integer> set=new TreeSet<>();
        dfs(root,set);
        if (set.size()<2)return -1;
        ArrayList<Integer> list=new ArrayList<>(set);
        return list.get(1);
    }

    public void dfs(TreeNode root, TreeSet<Integer> set)
    {
        if (root==null)return;
        set.add(root.val);
        dfs(root.left,set);
        dfs(root.right,set);
    }

    /**
     * @description TODO  这个题目的意思的第一小的一定是的根节点
     * @param: root
     * @date: 2021/5/3 12:48
     * @return: int
     * @author: xjl
    */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        //如果你找到的根部节点大于的时候就可以返回了
        if (root.val > min) {
            return root.val;
        }
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }

}
