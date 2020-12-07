package 牛客面试必会100题;

import java.util.HashMap;

/**
 * @Classname 矩阵元素的查找
 * @Description TODO
 * @Date 2020/12/1 13:16
 * @Created by xjl
 */
public class 矩阵元素的查找 {

    public int[] findElement(int[][] mat, int n, int m, int x) {
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        if (map.containsKey(x)) {
            return map.get(x);
        } else {
            return null;
        }
    }
}
