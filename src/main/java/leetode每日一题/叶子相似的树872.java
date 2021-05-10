package leetode每日一题;

import java.util.ArrayList;

/**
 * @Classname 叶子相似的树872
 * @Description TODO
 * @Date 2021/5/10 9:04
 * @Created by xjl
 */
public class 叶子相似的树872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
//        //比较这个list里面的是值是否相等于
//        if (list1.size() != list2.size()) {
//            return false;
//        } else {
//            for (int i = 0; i < list1.size(); i++) {
//                if (!list1.get(i).equals(list2.get(i))) {
//                    return false;
//                }
//            }
//            return true;
//        }
        //判断的这里两个是否相同
        return list1.equals(list2);
    }

    /**
     * @description TODO  这里是为了获取的是所有的叶子节点的值
     * @param: root1
     * @param: list
     * @date: 2021/5/10 9:12
     * @return: void
     * @author: xjl
     */
    private void dfs(TreeNode root1, ArrayList<Integer> list) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            list.add(root1.val);
        }
        dfs(root1.left, list);
        dfs(root1.right, list);
    }
}
