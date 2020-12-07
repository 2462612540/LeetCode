/**
 * Copyright (C), 2018-2020
 * FileName: convertBST538
 * Author:   xjl
 * Date:     2020/8/21 12:47
 * Description:
 */
package leetcode;

import java.util.LinkedList;

public class convertBST538 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode node=root;
        int sum=0;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.add(node);
                node=node.right;
            }
            TreeNode temp=stack.pollLast();
            sum+= temp.val;
            temp.val=sum;
            node=temp.left;
        }
        return root;
    }

    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
