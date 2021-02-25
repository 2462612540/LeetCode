/**
 * Copyright (C), 2018-2020
 * FileName: listOfDepth0403
 * Author:   xjl
 * Date:     2020/8/13 15:37
 * Description:
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class listOfDepth0403 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 采用的是的层序遍历
     * 在 对结果做一次的链表的创建
     *
     * @param tree
     * @return
     */

    public ListNode[] listOfDepth(TreeNode tree) {

        //层序遍历
        List<List<Integer>> result = cengxu(tree);
        ListNode[] ans = new ListNode[result.size()];
        int index = 0;
        //对每一组数据构建新的节点
        for (List list : result) {
            //构建链表
            ListNode head = new ListNode(-1);
            ListNode curr=head;
            for (int i = 0; i < list.size(); i++) {
                curr.next = new ListNode((Integer) list.get(i));
                curr = curr.next;
            }
            ans[index++] = head.next;
        }
        return ans;
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    private List<List<Integer>> cengxu(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }
}
