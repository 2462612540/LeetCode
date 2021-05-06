package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二叉树的所有的路径
 * @Description TODO
 * @Date 2021/4/30 14:26
 * @Created by xjl
 */
public class 二叉树的所有的路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        dfs(list, root, "");
        return list;
    }

    private void dfs(List<String> list, TreeNode root, String str) {
        if (root == null) {
            return;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        } else {
            sb.append("->");
            dfs(list, root.left, sb.toString());
            dfs(list, root.right, sb.toString());
        }
    }
}
