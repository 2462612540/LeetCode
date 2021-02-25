package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二叉树所有的路径
 * Author:   xjl
 * Date:     2020/10/5 21:12
 * Description:
 */


import java.util.ArrayList;
import java.util.List;

public class 二叉树所有的路径 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        searchPaths(root, "", result);
        return result;
    }

    private void searchPaths(TreeNode root, String curPath, List<String> result) {
        // 递归结束 标志
        if (root == null) {
            return;
        }
        StringBuilder builder = new StringBuilder(curPath);
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(builder.toString());
        } else {
            builder.append("->");
            searchPaths(root.left, builder.toString(), result);
            searchPaths(root.right, builder.toString(), result);
        }
    }
}
