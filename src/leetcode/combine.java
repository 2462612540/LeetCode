/**
 * Copyright (C), 2018-2020
 * FileName: combine
 * Author:   xjl
 * Date:     2020/4/23 18:29
 * Description: 组合
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class combine {
    List<List<Integer>> lists = new ArrayList<>();

    public void generCombinations(int n, int k, int start, List<Integer> list) {
        //递归的结束的条件
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //还有k-list。size()个位置的数据
        //i最多是n-(k-list.size)+1表示了减枝的这样的恶一个效果

        for (int i = start; i <= n; i++) {
            list.add(i);
            generCombinations(n, k, i + 1, list);
            //回溯的过程
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        generCombinations(n, k, 1, list);
        return lists;
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2).toString());
    }
}
