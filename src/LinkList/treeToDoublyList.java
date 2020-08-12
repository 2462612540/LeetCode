/**
 * Copyright (C), 2018-2020
 * FileName: treeToDoublyList
 * Author:   xjl
 * Date:     2020/8/12 16:51
 * Description: 二叉树的与双相链表
 */
package LinkList;

/**
 * 二叉树的变成一个双相链表
 * 一：遍历的的方式
 * 二：判断链表的尾部节点和遍历的当前的节点的关系
 * 三：原来的二叉树指向是否需要改动
 */
public class treeToDoublyList {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private TreeNode ans;//最终的双链表的头部

    private TreeNode removeNode;//双向链表的尾部节点

    private void dfs(TreeNode node, int flag) {
        //flag 表示的是的第n+1层的节点的方向   0表示的第n+1层左孩子    1表示的是第n+1的右孩子
        if (node != null) {
            //遍历左子树
            dfs(node.left, 0);
        }
        if (ans == null) {
            ans = node;
            removeNode = node;
        } else {
            //做好一般的处理 添加一个边、修改边
            if (flag == 0) {
                removeNode.right = node;//从尾部节点的引出一条指向当前的节点 也就是说创建一个从小到大的边
                node.left = removeNode;//这行代码对于非root节点是没有影响的 主要是为了修改是的root的左孩子的
            } else {
                removeNode.right = node;//这行代码对于非root节点是没有影响的 主要是为了修改是的root的右边孩子的
                node.left = removeNode;//从尾部节点的引出一条指向当前的节点 也就是说创建一个大到小的边
            }
            removeNode = node;//更新的双向链表的节点
        }
        if (node.right != null) {
            dfs(node.right, 1);
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        ans = null;
        removeNode = null;
        dfs(root, 0);
        return ans;
    }
}
