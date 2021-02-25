/**
 * Copyright (C), 2018-2020
 * FileName: leafSimilar872
 * Author:   xjl
 * Date:     2020/8/21 14:11
 * Description:
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;

public class leafSimilar872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = slove(root1, new ArrayList<>());
        List<Integer> list2 = slove(root2, new ArrayList<>());
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> slove(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            slove(root.left, list);
        }
        if (root.right != null) {
            slove(root.right, list);
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        return list;
    }
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        preRootTraverse(root1,list1);
        preRootTraverse(root2,list2);
        return list1.equals(list2);
    }

    public void preRootTraverse(TreeNode root,List<Integer> list){
        if(root!=null){
            if(root.left==null&&root.right==null){
                list.add(root.val);
            }
            preRootTraverse(root.left,list);
            preRootTraverse(root.right,list);
        }
    }
}
