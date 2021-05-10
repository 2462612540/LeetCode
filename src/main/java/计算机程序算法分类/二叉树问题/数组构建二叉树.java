package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 数组构建二叉树
 * @Description TODO
 * @Date 2021/5/10 19:13
 * @Created by xjl
 */
public class 数组构建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] array, int letf, int right) {
        if (letf > right) {
            return null;
        }
        int mid = letf + (right - letf) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedArrayToBST(array, letf, mid - 1);
        root.right = sortedArrayToBST(array, mid + 1, right);
        return root;
    }
}
