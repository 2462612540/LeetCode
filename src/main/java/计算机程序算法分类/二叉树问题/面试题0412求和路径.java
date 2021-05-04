package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 面试题0412求和路径
 * @Description TODO 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * @Date 2021/5/4 15:48
 * @Created by xjl
 */
public class 面试题0412求和路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int res=0;
    /**
     * @description TODO  根据题意，可以把满足和为给定值的路径看作是给定二叉树的子树。那么就可以将此题转化为求满足所有节点和为给定值的子树和。
      * @param: root
     * @param: sum
     * @date: 2021/5/4 15:54
     * @return: int
     * @author: xjl
    */
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private int dfs(TreeNode root,int sum){
        if(root==null) return 0;
        sum-=root.val;
        //这里不能在sum==0时直接return 1;
        // if(sum==0) return 1;
        return (sum==0?1:0)+dfs(root.left,sum)+dfs(root.right,sum);
    }

}
