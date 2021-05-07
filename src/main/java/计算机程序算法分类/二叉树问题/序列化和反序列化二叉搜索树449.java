package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 序列化和反序列化二叉搜索树449
 * @Description TODO
 * @Date 2021/5/7 15:05
 * @Created by xjl
 */
public class 序列化和反序列化二叉搜索树449 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //中序遍历
        String string = "";
        dfs(root, string);
        return string;
    }

    private void dfs(TreeNode root, String string) {
        if (root == null) {
            return;
        }
        dfs(root.left, string);
        string += String.valueOf(root.val);
        dfs(root.right, string);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfs2(data, 0, data.length() - 1);
    }

    private TreeNode dfs2(String data, int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(Integer.valueOf(data.charAt(mid)));
        root.left = dfs2(data, left, mid - 1);
        root.right = dfs2(data, mid + 1, right);
        return root;
    }
}
