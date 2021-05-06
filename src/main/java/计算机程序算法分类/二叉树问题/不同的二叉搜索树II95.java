package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 不同的二叉搜索树II95
 * @Description TODO
 * @Date 2021/5/6 13:26
 * @Created by xjl
 */
public class 不同的二叉搜索树II95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
    /**
     * @description TODO  生成一棵二叉树可以简化为：生成根，生成左子树，生成右子树，拼接。
      * @param: start
     * @param: end
     * @date: 2021/5/6 13:40
     * @return: java.util.List<计算机程序算法分类.二叉树问题.不同的二叉搜索树II95.TreeNode>
     * @author: xjl
    */
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public List<TreeNode> generateTrees2(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
        ArrayList<TreeNode> list = new ArrayList<>();

        if (n == 1) {
            list.add(new TreeNode(1));
        }
        dfs(array, 0, array.length - 1);
        return list;
    }

    /**
     * @description TODO 产生高度相似的树的算法
     * @param: n
     * @date: 2021/5/6 13:27
     * @return: java.util.List<计算机程序算法分类.二叉树问题.不同的二叉搜索树II95.TreeNode>
     * @author: xjl
     */
    private TreeNode dfs(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = dfs(array, left, mid - 1);
        root.right = dfs(array, mid + 1, right);
        return root;
    }

}
