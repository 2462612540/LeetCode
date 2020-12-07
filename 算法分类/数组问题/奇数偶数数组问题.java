/**
 * Copyright (C), 2018-2020
 * FileName: 奇数偶数数组问题
 * Author:   xjl
 * Date:     2020/9/10 13:51
 * Description:
 */
package 数组问题;

import java.util.Arrays;


/**想法：采用的是的双指针的问题
 * 1.遍历。将奇数放在左边，偶数放在右边
 * 2.先遍历左边，直到出现不是奇数的时候为止
 * 3.再遍历右边，直到出现不是偶数的时候为止
 * 4.交换位置
 */
public class 奇数偶数数组问题 {

    public static void main(String[] args) {
        int [] a={5,10,26,32,41,7,9,8,4,12,1};;
        int low = 0;
        int high = a.length-1;
        while(low < high) {
            int i = low;
            //从数组的左边开始遍历
            while(a[i]%2 != 0) {
                low++;
                i = low;
            }
            int index = i;//当前出现的偶数的位置下标

            i = high;
            //从数组的右边开始遍历
            while(a[i]%2 == 0) {
                high--;
                i = high;
            }

            //交换
            if(low < high) {
                int tmp = a[index];
                a[index] = a[i];
                a[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
