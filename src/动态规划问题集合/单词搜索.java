/**
 * Copyright (C), 2018-2020
 * FileName: 单词搜索
 * Author:   xjl
 * Date:     2020/9/8 18:27
 * Description:
 */
package 动态规划问题集合;

import java.util.Scanner;

public class 单词搜索 {

    //四个方向
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int x, y;
    //定义的是否访问的数组的
    static boolean[][] visit;

    public static boolean test(char[][] board, String word) {
        x = board.length;
        y = board[0].length;
        //初始化的是的时候就是false
        visit = new boolean[x][y];
        //开始遍历每一个数字
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (searchword(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchword(char[][] board, String word, int index, int startx, int starty) {
        //递归的终止条件
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        //判断是否为字符串中的数
        if (board[startx][starty] == word.charAt(index)) {
            visit[startx][starty] = true;
            //从四个方向开始往下寻找
            for (int i = 0; i < 4; i++) {
                //开始的计算新的x和y的位置
                int newxx = startx + d[i][0];
                int newyy = starty + d[i][1];
                //判断是否超出范围和是否访问过了
                if (inArea(newxx, newyy) && !visit[newxx][newyy]) {
                    //进行递归的下去
                    if (searchword(board, word, index + 1, newxx, newyy)) {
                        return true;
                    }
                }
            }
            //进行回溯的
            visit[startx][starty] = false;
        }
        return false;
    }

    //判断是否在矩阵中
    private static boolean inArea(int newxx, int newyy) {
        return newxx >= 0 && newxx < x && newyy >= 0 && newyy < y;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().trim();
        if (word.length()==0){
            System.out.println("false");
        }else {
            boolean res = test(board, word);
            System.out.println(res);
        }
    }
}
