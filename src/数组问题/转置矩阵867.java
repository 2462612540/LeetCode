package 数组问题;

import org.junit.Test;

/**
 * @Classname 转置矩阵867
 * @Description TODO
 * @Date 2020/11/30 13:26
 * @Created by xjl
 * <p>
 * <p>
 * 在交换的 a b的数值的时候不使用其他的变量
 * a = a + b
 * b = a - b
 * a = a - b
 */
public class 转置矩阵867 {
    /**
     * @description TODO 需要考虑的是使用的是是否为的对称矩阵，如果不是的话，那就需要使用的重新赋值
     * @param: A
     * @date: 2020/11/30 13:42
     * @return: int[][]
     * @author: xjl
     */
    public int[][] transpose(int[][] A) {
        if (A.length == A[0].length) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    A[i][j] = A[i][j] + A[j][i];
                    A[j][i] = A[i][j] - A[j][i];
                    A[i][j] = A[i][j] - A[j][i];
                }
            }
            return A;
        } else {
            int[][] result = new int[A[0].length][A.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = A[j][i];
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        int[][] arr = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
