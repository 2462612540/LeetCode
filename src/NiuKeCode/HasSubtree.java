/**
 * Copyright (C), 2018-2020
 * FileName: HasSubtree
 * Author:   xjl
 * Date:     2020/5/9 13:07
 * Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
package NiuKeCode;

public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1.val!=root2.val){

        }
        //递归的终止条件是什么
        if (root1.val == root2.val) {
            HasSubtree(root1, root2);
        }
        //递归的过程
        else {
            HasSubtree(root1.left, root2);
            HasSubtree(root1.right, root2);
        }
        return true;
    }

}
