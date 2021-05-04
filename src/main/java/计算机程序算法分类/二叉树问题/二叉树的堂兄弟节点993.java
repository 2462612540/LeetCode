package 计算机程序算法分类.二叉树问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 二叉树的堂兄弟节点993
 * @Description TODO
 * @Date 2021/5/4 14:45
 * @Created by xjl
 */
public class 二叉树的堂兄弟节点993 {

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

    Map<Integer, Integer> depth;//记录好节点深度
    Map<Integer, TreeNode> parent;//记录节点的父节点

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
