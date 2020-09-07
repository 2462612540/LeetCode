/**
 * Copyright (C), 2018-2020
 * FileName: 二叉树的路径和
 * Author:   xjl
 * Date:     2020/9/6 15:37
 * Description:
 */
package 二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的深度搜索的遍历
 */
public class 二叉树的路径和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        slove(root, sum, 0, list);
        return res;
    }

    /**
     * @param node   二叉树的节点
     * @param target 目标的和
     * @param sum    当前路径和
     * @param list   保存当前路径
     */
    private void slove(TreeNode node, int target, int sum, ArrayList<Integer> list) {
        if (node != null) {
            sum += node.val;
            list.add(node.val);
            if (node.left == null && node.right == null) {
                if (sum == target) {
                    ArrayList<Integer> ans = new ArrayList<>(list);
                    res.add(ans);
                }
            } else {
                slove(node.left, target, sum, list);
                slove(node.right, target, sum, list);
            }
            //消除当前节点的对查找路径的影响
            list.remove(list.size() - 1);
        }
    }

}
