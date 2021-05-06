package 计算机程序算法分类.二叉树问题;

import 牛客网练习题.Solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 有多少中的不同的二叉树
 * @Description TODO
 * @Date 2021/5/6 13:44
 * @Created by xjl
 */
public class 有多少中的不同的二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int numTrees(int n) {
        return generateTrees(n).size();
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTreesTest(1, n);
    }

    private List<TreeNode> generateTreesTest(int left, int right) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (left > right) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftnode = generateTreesTest(left, i - 1);
            List<TreeNode> rightnode = generateTreesTest(i + 1, right);
            for (TreeNode leftno : leftnode) {
                for (TreeNode rightno : rightnode) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftno;
                    currTree.right = rightno;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    /**
     * @description TODO 采用的动态规划的思想
     * @param: n
     * @date: 2021/5/6 13:54
     * @return: int
     * @author: xjl
     */
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
