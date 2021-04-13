package 计算机程序算法分类.二叉树问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 前中序数组构造二叉树
 * @Description TODO
 * @Date 2021/4/12 15:50
 * @Created by xjl
 */
public class 前中序数组构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length-1;
        int inLen = inorder.length-1;
        if (preLen != inLen) {
            return null;
        }
        //存储中序遍历的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //构建二叉树
        return dfs(preorder, 0, preLen, map, 0, inLen);
    }

    private TreeNode dfs(int[] preorder, int preLfet, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLfet > preRight || inLeft > inRight) {
            return null;
        }
        int rootval = preorder[preLfet];
        TreeNode root = new TreeNode(rootval);
        int Pindex = map.get(rootval);
        root.left = dfs(preorder, preLfet + 1, Pindex + preLfet - inLeft, map, inLeft, Pindex - 1);
        root.right = dfs(preorder, Pindex + preLfet - inLeft + 1, preRight, map, Pindex + 1, inRight);
        return root;
    }
}
