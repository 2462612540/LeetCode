package 计算机程序算法分类.二叉树问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 二叉搜索树的众数
 * @Description TODO
 * @Date 2021/4/30 15:13
 * @Created by xjl
 */
public class 二叉搜索树的众数 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        //中序遍历
        dfs(root, list);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        int count = 0;
        int maxcount = 0;
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (left < arr.length && right < arr.length) {
            while (right < arr.length && arr[left] == arr[right]) {
                count++;
                right++;
            }
            if (maxcount < count) {
                maxcount = count;
                if (res.size() != 0) {
                    res.remove(res.size() - 1);
                }
                res.add(arr[left]);
            } else if (maxcount == count) {
                maxcount = count;
                res.add(arr[left]);
            }
            count = 0;
            left = right;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

    public int[] test11(int[] arr) {
        int count = 0;
        int maxcount = 0;
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>();
        //使用的滑动窗口
        while (left < arr.length && right < arr.length) {
            while (right < arr.length && arr[left] == arr[right]) {
                count++;
                right++;
            }
            if (maxcount < count) {
                maxcount = count;
                res.clear();
                res.add(arr[left]);
            } else if (maxcount == count) {
                maxcount = count;
                res.add(arr[left]);
            }
            count = 0;
            left = right;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        int[] arr = new int[]{4, 3, 6, 2, 4, 6, 7, 4, 4, 6};
        Arrays.sort(arr);
        int[] ints = test11(arr);
        System.out.println(Arrays.toString(ints).toString());
    }

}
