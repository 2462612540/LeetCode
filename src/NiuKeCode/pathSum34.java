/**
 * Copyright (C), 2018-2020
 * FileName: pathSum34
 * Author:   xjl
 * Date:     2020/8/20 18:36
 * Description: 二叉树的某一个值的路径
 */
package NiuKeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的偶一个路径
 */
public class pathSum34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(root, sum, 0, list);
        return result;
    }

    private void slove(TreeNode node, int target, int sum, List<Integer> list) {
        if (node != null) {
            sum += node.val;
            list.add(node.val);
            //判断是否当了更节点
            if (node.left == null && node.right == null) {
                if (sum == target) {
                    ArrayList<Integer> res = new ArrayList<>(list);
                    result.add(res);
                }
            } else {
                //左子树
                slove(node.left, target, sum, list);
                //右子树
                slove(node.right, target, sum, list);
            }
            //消除当前的节点的查找的路径的影响
            sum -= node.val;
            list.remove(list.size() - 1);
        }
    }

    private ArrayList<ArrayList<Integer>> ans;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        Slove(root, target, 0, pathList);
        return null;
    }

    private void Slove(TreeNode root, int target, int i, ArrayList<Integer> pathList) {
    }

}
