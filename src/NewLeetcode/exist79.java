/**
 * Copyright (C), 2018-2020
 * FileName: exist79
 * Author:   xjl
 * Date:     2020/6/1 20:41
 * Description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。  单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package NewLeetcode;

public class exist79 {
    //四个方向
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //表示的坐行列数值
    int m, n;
    //表示的访问过的标志
    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        //赋值没有访问过都为false
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        //开始遍历是否有事相同的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //开始0表示的字符中第一个字符
                if (searchword(board, word, 0, i, j)) {
                    //如果匹配成功了那就直接返回啦
                    return true;
                }
            }
        }
        return false;
    }

    //递归函数
    private boolean searchword(char[][] board, String word, int index, int startx, int starty) {
        //递归的终止条件
        if (index == word.length() - 1) {
            //如果长度等于了，这个时候还要看这个最后一个字符是否是字符串的最后一个
            return board[startx][starty] == word.charAt(index);
        }
        //递归的流程
        if (board[startx][starty] == word.charAt(index)) {
            //每一次访问一个就将标志位置设置为true表示的访问成功
            visit[startx][starty] = true;
            //分别从四个方向来向下开始搜索
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                //判断新的坐标是否在整个矩阵的范围之内并且整个新的位置的坐标是没有访问过的
                if (inArea(newx, newy) && !visit[newx][newy]) {
                    //如果是那就递归的调用的
                    if (searchword(board, word, index + 1, newx, newy)) {
                        //如果递归一直返回的是true
                        return true;
                    }
                }
            }
            //访问完成后需要将原来的数据设置成为没有访问 这里是需要回溯的部分
            visit[startx][starty] = false;
        }
        //如果每一遇见不相同的时候就直接返回来false
        return false;
    }

    //判断是否在矩阵中
    private boolean inArea(int newx, int newy) {
        //判断新的x y的值是否大于0 小于m n的值
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
