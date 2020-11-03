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

public class 杨辉三角118II {

    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
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
        return lists.get(rowIndex);
    }

    /**
     * 这里就是计算了很多不需要的值
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        int numRows = rowIndex + 1;
        int[][] result = new int[numRows][numRows];
        ArrayList<Integer> list = new ArrayList<>();
        //开始赋值列值和对角线的值
        for (int i = 0; i < numRows; i++) {
            result[i][0] = 1;
            result[i][i] = 1;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                }
                if (i == rowIndex) {
                    list.add(result[i][j]);
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        List<Integer> row = getRow2(3);
        for (int i : row) {
            System.out.print(i + " ");
        }
    }
}
