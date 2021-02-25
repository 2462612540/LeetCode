package 牛客网名企高频面试题;

/**
 * @Classname 判断是否为的二叉搜索树
 * @Description TODO
 * @Date 2020/12/18 13:44
 * @Created by xjl
 */
public class 判断是否为的二叉搜索树和完全二叉树 {

    public boolean[] judgeIt(TreeNode root) {
        boolean isBalance = judgeBalance(root);
        boolean isSearch = judgeSearch(root);
        return new boolean[]{isSearch, isBalance};
    }

    private boolean judgeSearch(TreeNode root) {
        TreeNode cur = root;
        TreeNode rightNode;
        int temp = Integer.MIN_VALUE;
        while (cur != null) {
            rightNode = cur.left;
            if (rightNode != null) {
                while (rightNode.right != null && rightNode.right != cur) {
                    rightNode = rightNode.right;
                }
                if (rightNode.right == null) {
                    rightNode.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    rightNode.right = null;
                }
            }
            if (temp < cur.val) {
                //什么都不做继续
                temp = cur.val;
            } else {
                //返回false;
                return false;
            }
            cur = cur.right;
        }
        return true;
    }

    private boolean judgeBalance(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        judgeHeight(root, res);
        return res[0];
    }

    private int judgeHeight(TreeNode root, boolean[] i) {
        if (i[0] == false) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int l = judgeHeight(root.left, i) + 1;
        int r = judgeHeight(root.right, i) + 1;
        if (Math.abs(r - l) > 1) {
            i[0] = false;
        }
        return Math.max(l, r);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
