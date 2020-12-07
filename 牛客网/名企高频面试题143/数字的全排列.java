package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.数字的全排列
 * Author:   xjl
 * Date:     2020/9/29 13:05
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 数字的全排列 {

    @Test
    public void test2() {
        ArrayList<ArrayList<Integer>> lists = permute(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[num.length];
        test11(num, 0, vis, list, lists);
        return lists;
    }

    private void test11(int[] num, int index, boolean[] vis, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if (index == num.length) {
            lists.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < num.length; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    list.add(num[i]);
                    test11(num, index + 1, vis, list, lists);
                    list.remove(list.size() - 1);
                    vis[i] = false;
                } else {
                    continue;
                }
            }
        }
    }

}
