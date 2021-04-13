package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 前中序数组构造二叉树  这里是的没有的重复的数字
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
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }
        //存储中序遍历的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTreedfs(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTreedfs(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootval = preorder[preLeft];
        //简历根节点
        TreeNode root = new TreeNode(rootval);
        int pIndex = map.get(rootval);
        //构造左子树
        root.left = buildTreedfs(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        //构造右子树
        root.right = buildTreedfs(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }

}
