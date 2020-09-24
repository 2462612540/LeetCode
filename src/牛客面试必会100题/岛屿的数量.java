/**
 * Copyright (C), 2018-2020
 * FileName: 岛屿的数量
 * Author:   xjl
 * Date:     2020/9/23 21:33
 * Description:
 */
package 牛客面试必会100题;

import java.util.LinkedList;

/**
 * 采用的是深度优先搜索的 是的栈溢出的效果
 */
public class 岛屿的数量 {

    //记录矩阵的行列
    static int row, col;
    //记录好是否访问
    static boolean[][] vis;
    //记录好四个方向
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int solve(char[][] grid) {
        //判断矩阵
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        vis = new boolean[row][col];
        //记录岛屿的数量
        int amount = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //保证是 1且没有被访问过
                if (!vis[i][j] && grid[i][j] == '1') {
                    amount++;
                    //这里不需要进行回溯的，只需要的是的判断时候遍历没有
                    dfstest(grid, i, j);
                }
            }
        }
        return amount;
    }

    //开始进行深度遍历
    private static void dfstest(char[][] grid, int i, int j) {
        vis[i][j] = true;
        //开始访问四个方向
        for (int k = 0; k < 4; k++) {
            int nx = i + d[k][0];
            int ny = j + d[k][1];
            // 如果不越界、没有被访问过、并且还要是陆地
            if (Area(nx, ny) && grid[nx][ny] == '1' && !vis[nx][ny]) {
                dfstest(grid, nx, ny);
            }
        }
    }

    private static boolean Area(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        char[][] grid = {{1, 1}, {1, 1}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        int solve = solve(grid);
        System.out.println(solve);
    }

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    //里面存储的是的横纵坐标的和 这样也是唯一的
                    LinkedList<Integer> queue = new LinkedList<>();
                    // 小技巧：把坐标转换为一个数字
                    // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                    queue.addLast(i * cols + j);
                    // 注意：这里要标记上已经访问过
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        // 得到 4 个方向的坐标
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                // 在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                // 而不是在出队列的时候再标记
                                // 如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inArea(int x, int y) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
