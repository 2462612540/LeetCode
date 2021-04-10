package 计算机程序算法分类.二分查找问题;

import org.junit.Test;

/**
 * @Classname 两个数组合并
 * @Description TODO
 * @Date 2021/4/10 14:53
 * @Created by xjl
 */
public class 两个数组合并 {
    /**
     * @description TODO 归并的倒排序的功能      归并排序的功能
     * @param: arr1
     * @param: arr2
     * @date: 2021/4/10 15:08
     * @return: int[]
     * @author: xjl
     */
    public int[] merge2(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }
        if (arr1.length == 0 && arr2.length == 0) {
            return null;
        }
        int[] result = new int[arr1.length + arr2.length];
        int p1 = arr1.length - 1, p2 = arr2.length - 1, p3 = result.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] < arr2[p2]) {
                result[p3--] = arr2[p2--];
            } else {
                result[p3--] = arr1[p1--];
            }
        }
        while (p1 >= 0) {
            result[p3--] = arr1[p1--];
        }
        while (p2 >= 0) {
            result[p3--] = arr2[p2--];
        }
        return result;
    }

    /**
     * @description TODO  从前开始的合并
     * @param: arr1
     * @param: arr2
     * @date: 2021/4/10 15:07
     * @return: int[]
     * @author: xjl
     */
    public int[] merge(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }
        if (arr1.length == 0 && arr2.length == 0) {
            return null;
        }
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] > arr2[p2]) {
                result[p3++] = arr2[p2++];
            } else {
                result[p3++] = arr1[p1++];
            }
        }
        while (p1 < arr1.length) {
            result[p3++] = arr1[p1++];

        }
        while (p2 < arr2.length) {
            result[p3++] = arr2[p2++];
        }
        return result;
    }

    @Test
    public void test() {
        int[] merge = merge2(new int[]{1, 2, 5}, new int[]{2, 8, 9});
        for (int i : merge) {
            System.out.print(i + " ");
        }
    }
}
