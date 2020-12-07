/**
 * Copyright (C), 2018-2020
 * FileName: Treemax
 * Author:   xjl
 * Date:     2020/7/28 16:08
 * Description: 最大的快日的值
 */
package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Treemax {

    public static void DFS(ArrayList<Integer>[] arr, int[] happy, int root, int[][] dfs) {
        dfs[root][0] = 0;          //领导不去
        dfs[root][1] = happy[root];//领导去，则快乐值至少为自己快乐值
        if (arr[root] != null) {
            for (int i = 0; i < arr[root].size(); i++) {
                int j = arr[root].get(i);
                DFS(arr, happy, j, dfs);
                dfs[root][0] += Math.max(dfs[j][0], dfs[j][1]);
                dfs[root][1] += dfs[j][0];
            }
        }
    }

    /**
     * 3 1
     * 5 1 1
     * 1 2
     * 1 3
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> map=new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");

        int num = Integer.parseInt(str1[0]);//公司总人数
        int N = num + 1;

        int root = Integer.parseInt(str1[1]);//根节点
        String[] str2 = br.readLine().split(" ");

        int[] happy = new int[N];

        for (int i = 0; i < num; i++) {
            happy[i + 1] = Integer.parseInt(str2[i]);//每个员工的快乐值
        }
        //创建一个的Arraylist的数组
        ArrayList<Integer>[] arr = new ArrayList[N];

        for (int i = 0; i < num - 1; i++) {
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);//起点
            int v = Integer.parseInt(str[1]);//终点
            if (arr[u] == null) {
                arr[u] = new ArrayList<>();
            }
            arr[u].add(v);
        }
        int[][] dfs = new int[arr.length][2];
        DFS(arr, happy, root, dfs);
        System.out.println(Math.max(dfs[root][0], dfs[root][1]));
    }
}
