package 牛客网名企高频面试题143;

/**
 * @Classname 平衡二叉搜索树
 * @Description TODO
 * @Date 2020/12/13 14:49
 * @Created by xjl
 */
public class 平衡二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return helper(num, 0, num.length - 1);
    }

    private TreeNode helper(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(num[left]);
        }
        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode lNode = helper(num, left, mid - 1);
        TreeNode rNode = helper(num, mid + 1, right);
        if (lNode != null) root.left = lNode;
        if (rNode != null) root.right = rNode;
        return root;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
