/**
 * Copyright (C), 2018-2020
 * FileName: 根据身高重建队列406
 * Author:   xjl
 * Date:     2020/11/16 14:54
 * Description:
 */
package 每日一题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列406 {
    public int[][] reconstructQueue(int[][] people) {
        //采用的排序的新采用的是按照身高排序 从高的开始排序
        //Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    //如果有相等于的话那就按照前面的来判断
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    @Test
    public void test() {
        int[][] ints = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}
