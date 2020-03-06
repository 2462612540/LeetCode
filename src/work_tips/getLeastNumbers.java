/**
 * Copyright (C), 2018-2020
 * FileName: getLeastNumbers
 * Author:   xjl
 * Date:     2020/3/5 13:04
 * Description: 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
package work_tips;

import java.util.Arrays;

public class getLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] number = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            number[i] = arr[i];
        }
        for (int va : number) {
            System.out.println(va);
        }
        return number;
    }

    public static void main(String[] args) {
        int[] number = {0,1,2,1};
        getLeastNumbers(number, 1);
    }
}
