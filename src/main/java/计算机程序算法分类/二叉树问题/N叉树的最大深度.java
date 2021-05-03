package 计算机程序算法分类.二叉树问题;

import javafx.util.Pair;

import java.util.*;

/**
 * @Classname N叉树的最大深度
 * @Description TODO
 * @Date 2021/5/3 9:54
 * @Created by xjl
 */
public class N叉树的最大深度 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> _children) {
            this.val = val;
            children = _children;
        }
    }

    //N叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    /**
     * @description TODO 采油的递归的方法来实现
     * @param: root
     * @date: 2021/5/3 10:04
     * @return: int
     * @author: xjl
     */
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        List<Integer> deepth = new ArrayList<>();
        for (Node node : root.children) {
            deepth.add(dfs(node));
        }
        return Collections.max(deepth) + 1;
    }

    public int maxDepth1(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                for (Node c : root.children) {
                    stack.add(new Pair(c, current_depth + 1));
                }
            }
        }
        return depth;
    }
}
