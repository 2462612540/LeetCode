/**
 * Copyright (C), 2018-2020
 * FileName: 杨辉三角118
 * Author:   xjl
 * Date:     2020/11/2 16:35
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角118 {
    /**
     * 生成的杨辉三角的前n行 将杨辉三角看做是第一的矩阵来实现   result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int[][] result = new int[numRows][numRows];
        //开始赋值列值和对角线的值
        for (int i = 0; i < numRows; i++) {
            result[i][0] = 1;
            result[i][i] = 1;
        }
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                }
                list.add(result[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = generate(4);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
