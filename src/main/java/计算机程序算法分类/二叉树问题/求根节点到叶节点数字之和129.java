package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 求根节点到叶节点数字之和129
 * @Description TODO
 * @Date 2021/5/6 14:53
 * @Created by xjl
 */
public class 求根节点到叶节点数字之和129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO 这个题目变成可跟到叶子节点的和为多少
     * @param: root
     * @date: 2021/5/6 14:53
     * @return: int
     * @author: xjl
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> res = testsum(root);
        Integer ans = 0;
        for (String s : res) {
            ans += Integer.parseInt(s);
        }
        return ans;
    }

    private List<String> testsum(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode root, List<String> result, String str) {
        if (root == null) {
            return;
        }
        str += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            result.add(str);
        }
        dfs(root.left, result, str);
        dfs(root.right, result, str);
    }

    int sum = 0;

    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs1(root,"");
        return sum;
    }
    /**
     * @description TODO 不需要的将所有的路径记录下来 只是需要在的根节点的时候将结果加起来就行。
     * @param: root
     * @param: str
     * @date: 2021/5/6 15:08
     * @return: void
     * @author: xjl
    */
    private void dfs1(TreeNode root, String str) {
        if (root==null){return;}
        str+=String.valueOf(root.val);
        if (root.left==null&&root.right==null){
            sum+=Integer.valueOf(str);
            return;
        }
        dfs1(root.left,str);
        dfs1(root.right,str);
    }
}
