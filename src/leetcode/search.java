/**
 * Copyright (C), 2018-2020
 * FileName: search
 * Author:   xjl
 * Date:     2020/3/4 15:01
 * Description: 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

import java.util.Arrays;

public class search {
    public static int search(int[] arr, int target) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}