package 牛客网名企高频面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 中序遍历和后序遍历构造二叉树
 * @Description TODO
 * @Date 2020/12/17 16:46
 * @Created by xjl
 */
public class 中序遍历和后序遍历构造二叉树 {
    public int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode root = buildTree(xianxu, zhongxu);
        List<Integer> ans = getRightView(root);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * @description TODO  层序遍历
     * @param: root
     * @date: 2020/12/17 16:53
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> getRightView(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            TreeNode cur = null;
            while (size > 0) {
                size--;
                cur = list.removeFirst();
                if (cur.left != null) {
                    list.add(cur.left);
                }
                if (cur.right != null) {
                    list.add(cur.right);
                }
            }
            res.add(cur.val);
        }
        return res;
    }

    /**
     * @description TODO 重建的二叉树
     * @param: preorder
     * @param: inorder
     * @date: 2020/12/17 16:53
     * @return: 名企高频面试题143.中序遍历和后序遍历构造二叉树.TreeNode
     * @author: xjl
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归函数的出口是
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //获取到根节点的value的值
        TreeNode root = new TreeNode(preorder[0]);
        //构建left right子树
        int index = findIndex(preorder, inorder);
        // root.left = buildTree( 左子树的前序数组 左子树的中序数组);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        //root.right = buildTree(右子树的前序数组 右子树的中序数组);
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    /**
     * @description TODO 为了找到中序遍历的过程中位置
     * @param: preorder
     * @param: inorder
     * @date: 2020/12/17 16:54
     * @return: int
     * @author: xjl
     */
    private int findIndex(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                return i;
            }
        }
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
