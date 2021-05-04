package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 二叉树的前序遍历创建字符串606
 * @Description TODO
 * @Date 2021/5/4 14:59
 * @Created by xjl
 */
public class 二叉树的前序遍历创建字符串606 {
    /**
     * @description TODO  树节点的定义
     * @param: null
     * @date: 2020/12/23 10:36
     * @return:
     * @author: xjl
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
}
