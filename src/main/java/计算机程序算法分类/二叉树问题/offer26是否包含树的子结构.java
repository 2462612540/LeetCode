package 计算机程序算法分类.二叉树问题;

/**
 * @Classname 树的子结构offer26
 * @Description TODO
 * @Date 2021/4/30 13:20
 * @Created by xjl
 */
public class offer26是否包含树的子结构 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        //判断这个树是否相同 再去判断子树是否包含这个树
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //这个判断包含子树的条件就行了
    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        } else if (a == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        } else {
            return dfs(a.left, b.left) && dfs(a.right, b.right);
        }
    }


    //这个是需要完全相同的才行 这个条件有的不行
    private boolean dfs1(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        } else {
            return dfs(a.left, b.left) && dfs(a.right, b.right);
        }
    }
}
