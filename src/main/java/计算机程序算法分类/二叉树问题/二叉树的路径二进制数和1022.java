package 计算机程序算法分类.二叉树问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二叉树的路径二进制数和1022
 * @Description TODO
 * @Date 2021/5/4 10:35
 * @Created by xjl
 */
public class 二叉树的路径二进制数和1022 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return 0;
        dfs(root, list, "");
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s, 2);//将字符串转为的十进制数字
        }
        return sum;
    }

    private void dfs(TreeNode root, ArrayList<String> list, String str) {
        if (root == null) {
            return;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        } else {
            dfs(root.left, list, sb.toString());
            dfs(root.right, list, sb.toString());
        }
    }

    private void dfs2(TreeNode root, ArrayList<String> list, String str) {
        if (root == null) {
            return;
        }
        //就可以实现的字符串的相加的工作
        str += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(str);
        } else {
            dfs(root.left, list, str);
            dfs(root.right, list, str);
        }
    }

    public int sumRootToLeaf2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        //空节点，返回0
        if (root == null) return 0;
        //进位更新
        sum = (sum << 1) + root.val;
        //叶子节点直接返回当前和
        if (root.left == null && root.right == null) return sum;
        //递归
        return helper(root.left, sum) + helper(root.right, sum);
    }

    @Test
    public void test() {
        System.out.println(Integer.parseInt("110", 2));
    }
}
