/**
 * Copyright (C), 2018-2020
 * FileName: exit79
 * Author:   xjl
 * Date:     2020/6/1 21:14
 * Description: 查找二维举证中是否有相同的路径
 */
package leetcode练习题;

import org.junit.Test;

public class exit79 {
    int m, n;
    boolean[][] visit;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    //判断函数
    public Boolean exit(char[][] chars, String word) {
        n = chars.length;
        m = chars[0].length;
        //设置是否访问
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
            }
        }
        //开始遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (searchword(chars, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //递归函数
    public Boolean searchword(char[][] chars, String word, int index, int x, int y) {
        //递归的终止的条件
        if (index == word.length() - 1) {
            return chars[x][y] == word.charAt(index);
        }
        //递归函数
        if (chars[x][y] == word.charAt(index)) {
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (find(newx, newy) && !visit[newx][newy]) {
                    if (searchword(chars, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visit[x][y] = false;
        }
        return false;
    }

    //判断新的坐标是否为范围=之内
    public Boolean find(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    @Test
    public void test() {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";

        Boolean exit = exit(chars, word);
        System.out.println(exit);
    }
}
