package 牛客网名企高频面试题2020;

/**
 * @Classname 二叉树的直径
 * @Description TODO  给定一棵树，求出这棵树的直径，即树上最远两点的距离。 示例1的树如下图所示。其中4到5之间的路径最长，是树的直径，距离为5+2+4=11
 * @Date 2020/12/8 15:48
 * @Created by xjl
 */
public class 二叉树的直径 {
    //表示的结果
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //表示的至少是一
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
