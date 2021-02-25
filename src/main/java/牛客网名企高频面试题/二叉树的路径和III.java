package 牛客网名企高频面试题;

import java.util.ArrayList;

/**
 * @Classname 二叉树的路径和III
 * @Description TODO
 * @Date 2020/12/18 9:46
 * @Created by xjl
 */
public class 二叉树的路径和III {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); //用于存储结果
    ArrayList<Integer> temp = new ArrayList<Integer>(); //用于存储路径

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0);
        return res;
    }

    public void dfs(TreeNode root, int sum, int cnt) {
        // 如果节点为空结束当前递归
        if (root == null) return;
        //将当前节点加入tmp数组
        temp.add(root.val);
        //把当前节点加入到路径和中
        cnt += root.val;
        //当递归到没有子树的时候就需要判断
        if (root.left == null && root.right == null) {
            //如果当前节点的路径和等于sum，那么就在res中插入tmp
            if (cnt == sum) {
                res.add(temp);
            }
        } else {
            dfs(root.left, sum, cnt); //递归左子树
            dfs(root.right, sum, cnt); //递归右子树
        }
        temp.remove(temp.size() - 1);
    }

    /**
     * @description TODO 二叉树的定义
     * @param: null
     * @date: 2020/12/18 9:46
     * @return:
     * @author: xjl
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
