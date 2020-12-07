/**
 * Copyright (C), 2018-2020
 * FileName: rob337
 * Author:   xjl
 * Date:     2020/7/7 9:56
 * Description: 337. 打家劫舍 III
 */
package leetcode;

public class rob337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = postRoot(root);
        return Math.max(res[0],res[1]);
    }

    private int[] postRoot(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = postRoot(root.left);
        int[] r = postRoot(root.right);
        int[] res = new int[2];
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + root.val;
        return res;
    }

}
