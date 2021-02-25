/**
 * Copyright (C), 2018-2020
 * FileName: maxWidthRamp
 * Author:   xjl
 * Date:     2020/3/5 11:37
 * Description: 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。  找出 A 中的坡的最大宽度，如果不存在，返回 0   来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-width-ramp 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

public class maxWidthRamp {
    public static int maxWidthRamp(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j > i && (A[i] <= A[j])) {
                    return j - i;
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) {

    }
}
