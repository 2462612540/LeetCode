package 牛客网名企高频面试题2020;

import org.junit.Test;
import 牛客网练习题.Solution;

/**
 * @Classname 归并排序的理解
 * @Description TODO
 * @Date 2021/3/23 14:47
 * @Created by xjl
 */
public class 归并排序的理解 {
    /**
     * @description TODO  采用的归并的思想是采用的是将从后面开始进行查询
     * @param: A
     * @param: m
     * @param: B
     * @param: n
     * @date: 2021/3/23 14:52
     * @return: void
     * @author: xjl
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int temp;
        while (pa >= 0 || pb >= 0) {
            //如果是a为空的指针的话，那就选择是b中的元素
            if (pa == -1) {
                temp = B[pb--];
            } else if (pb == -1) {
                //如果是a为空的指针的话，那就选择是b中的元素
                temp = A[pa--];
            } else if (A[pa] > B[pb]) {
                temp = A[pa--];
            } else {
                temp = B[pb--];
            }
            A[tail--] = temp;
        }
    }

    public void merge2(int[] A, int[] B, int m, int n) {

    }

    @Test
    public void test() {
        int[] A = {1};
        int[] B = {};
        merge2(A, B, 1, 0);
    }

}
