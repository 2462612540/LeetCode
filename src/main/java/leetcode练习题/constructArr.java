/**
 * Copyright (C), 2018-2020
 * FileName: constructArr
 * Author:   xjl
 * Date:     2020/4/2 15:16
 * Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

public class constructArr {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            int sum = 1;
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    sum *= a[j];
                } else {
                    continue;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public int[] constructArr2(int[] a) {
        int[] res = new int[a.length];
        int temp = 1;
        int temp1 = 1;
        if (a.length != 0) {
            for (int i = 0; i < a.length; i++) {
                res[i] = temp;
                temp *= a[i];
            }
            for (int j = a.length - 1; j >= 0; j--) {
                res[j] = res[j] * temp1;
                temp1 *= a[j];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        for (int a : constructArr2(nums)) {
            System.out.println(a);
        }
    }
}
