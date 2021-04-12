package 计算机程序算法分类.dfs深度优先广度优先问题;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 二叉树的所有的结果
 * @Description TODO
 * @Date 2021/4/12 16:49
 * @Created by xjl
 */
public class 二叉树的所有的结果 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @description TODO 找到二叉树的所有结果
     * @param: root
     * @date: 2021/4/12 16:50
     * @return: java.util.ArrayList<java.lang.Integer>
     * @author: xjl
     */
    public ArrayList<Integer> findallresult(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        dfs(root, sum, list);
        return list;
    }

    private void dfs(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }
        dfs(root.left, sum + root.val, list);
        dfs(root.right, sum + root.val, list);
    }


    @Test
    public void test(){
        TreeNode root=new TreeNode(2);
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(6);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        ArrayList<Integer> findallresult = findallresult(root);
        for (int a:findallresult){
            System.out.println(a);
        }
    }
}
