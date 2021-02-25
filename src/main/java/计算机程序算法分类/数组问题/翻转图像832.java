package 计算机程序算法分类.数组问题;

import org.junit.Test;

/**
 * @Classname 翻转图像832
 * @Description TODO 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * @Date 2020/11/30 13:26
 * @Created by xjl
 */
public class 翻转图像832 {

    /**
     * @description TODO
     * @param: A
     * @date: 2020/11/30 14:23
     * @return: int[][]
     * @author: xjl
     */
    public int[][] flipAndInvertImage2(int[][] A) {
        int C = A[0].length;
        for (int[] row : A) {
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        //水平翻转
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                A[i][j] = A[i][j] + A[i][A.length - 1 - j];
                A[i][A.length - 1 - j] = A[i][j] - A[i][A.length - 1 - j];
                A[i][j] = A[i][j] - A[i][A.length - 1 - j];
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }

    @Test
    public void test() {
        int[][] ints = flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}});
        for (int[] a : ints) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
