/**
 * Copyright (C), 2018-2020
 * FileName: Treemax
 * Author:   xjl
 * Date:     2020/7/28 16:08
 * Description: 最大的快日的值
 */
package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class Treemax {
    //树的定义
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = new TreeNode(sc.nextInt());
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");

        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.valueOf(s[i]);
        }
        Arrays.sort(array);
        int result = array[array.length - 1];

        //调用函数

        //结果打印
        System.out.println(result);
    }
}
