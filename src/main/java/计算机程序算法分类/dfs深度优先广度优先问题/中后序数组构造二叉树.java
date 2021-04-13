package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 前中序数组构造二叉树
 * @Description TODO
 * @Date 2021/4/12 15:50
 * @Created by xjl
 */
public class 中后序数组构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length - 1;
        int poLen = postorder.length - 1;
        if (inLen != poLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(postorder, 0, poLen, map, 0, inLen);
    }
    /**
     * @description TODO 采用的和中序和谦虚的方式是一样的
     * @param: postorder
     * @param: PLeft
     * @param: PRight
     * @param: map
     * @param: inLeft
     * @param: inRight
     * @date: 2021/4/13 10:54
     * @return: 计算机程序算法分类.dfs深度优先广度优先问题.中后序数组构造二叉树.TreeNode
     * @author: xjl
    */
    private TreeNode dfs(int[] postorder, int PLeft, int PRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (PLeft > PRight || inLeft > inRight) {
            return null;
        }
        int rootval = postorder[PRight];
        TreeNode root = new TreeNode(rootval);
        int Index = map.get(rootval);
        root.left = dfs(postorder, PLeft, Index + PLeft-inLeft- 1, map, inLeft, Index - 1);
        root.right = dfs(postorder, Index + PLeft-inLeft, PRight - 1, map, Index + 1, inRight);
        return root;
    }
}
