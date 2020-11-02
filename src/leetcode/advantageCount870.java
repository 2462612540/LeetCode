/**
 * Copyright (C), 2018-2020
 * FileName: advantageCount870
 * Author:   xjl
 * Date:     2020/7/31 19:50
 * Description: 田忌赛马问题
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class advantageCount870 {

    public static int[] advantageCount(int[] a, int[] b) {
        int n = b.length;
        Arrays.sort(a);
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++)
            pair[i] = new int[]{b[i], i};//把下标保存下来
        Arrays.sort(pair, (x, y) -> x[0] - y[0]);

        int[] res = new int[n];
        for (int i = 0, r = n - 1, l = 0; i < n; i++)//r最大值，l标明最小值；
        {
            if (a[i] <= pair[l][0]) res[pair[r--][1]] = a[i];//要放到原数组对应的位置上
            else res[pair[l++][1]] = a[i];////要放到原数组对应的位置上
        }
        return res;
    }

    /**
     * 方法还是存在的一个是的可能有的是的数据的范围的原因
     * @param a
     * @param b
     * @return
     */
    public static int[] advantageCount1(int[] a, int[] b) {
        //定义一个list
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        //排序
        Collections.sort(list);
        int[] result = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            //表示的可以找一个比b中的大的数据
            int flag = 0;
            //找到list中的比b[i]中大的
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > b[i]) {
                    flag = 1;
                    result[i] = list.get(j);
                    list.remove(j);
                    break;
                }
            }
            if (flag == 0) {
                result[i] = Integer.MAX_VALUE;
            }
        }
        //将剩下的元素的插入里面
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = list.get(0);
                list.remove(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {12, 24, 8, 32};
        int[] b = {13, 25, 32, 11};
        int[] ints = advantageCount1(a, b);
        for (int V : ints) {
            System.out.println(V);
        }
        System.out.println((Integer.MAX_VALUE-Math.pow(10,9))>0);
    }
}
