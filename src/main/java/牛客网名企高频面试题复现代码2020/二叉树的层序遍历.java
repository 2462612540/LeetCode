package 牛客网名企高频面试题复现代码2020;

import java.util.*;

/**
 * @Classname 二叉树的层序遍历
 * @Description TODO
 * @Date 2020/12/23 10:44
 * @Created by xjl
 */
public class 二叉树的层序遍历 {

    public ArrayList<ArrayList<Integer>> cengxu(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        int sum = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum > 0) {
                TreeNode node1 = deque.poll();
                list.add(node1.val);
                if (node1.left != null) {
                    temp++;
                    deque.add(node1.left);
                }
                if (node1.right != null) {
                    temp++;
                    deque.add(node1.right);
                }
                sum--;
            }
            sum = temp;
            lists.add(list);
        }
        return lists;
    }

    public ArrayList<List<Integer>> cengxu2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (!queue.isEmpty()) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        int sum = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum > 0) {
                TreeNode node1 = deque.poll();
                list.add(node1.val);
                if (node1.left != null) {
                    temp++;
                    deque.add(node1.left);
                }
                if (node1.right != null) {
                    temp++;
                    deque.add(node1.right);
                }
                sum--;
            }
            sum = temp;
            lists.add(list);
        }
        Collections.reverse(lists);
        return lists;
    }

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
}
