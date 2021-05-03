package 计算机程序算法分类.二叉树问题;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname N叉树的前序遍历
 * @Description TODO
 * @Date 2021/5/3 10:21
 * @Created by xjl
 */
public class N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * @description TODO 参考的是的二叉树的前序遍历 根 左 右
     * @param: root
     * @date: 2021/5/3 10:21
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node1 : root.children) {
            dfs(node1, list);
        }
    }

    /**
     * @description TODO 后续遍历的表示左  右  根
     * @param: root
     * @param: list
     * @date: 2021/5/3 10:38
     * @return: void
     * @author: xjl
     */
    private void dfs2(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node1 : root.children) {
            dfs(node1, list);
        }
        list.add(root.val);
    }

    /**
     * @description TODO 采用的是的stack版本的
     * @param: root
     * @date: 2021/5/3 10:35
     * @return: java.util.List<java.lang.Integer>
     * @author: xjl
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        if (root == null) return list;
        while (!stack.isEmpty()) {
            //当前栈顶节点出栈
            Node node = stack.pop();
            //将值加入列表
            list.add(node.val);
            int size = node.children.size();
            //将当前节点的孩子们从右到左入栈
            for (int i = size - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
