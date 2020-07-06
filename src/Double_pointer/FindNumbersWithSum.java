/**
 * Copyright (C), 2018-2020
 * FileName: FindNumbersWithSum
 * Author:   xjl
 * Date:     2020/7/6 13:32
 * Description: 双指针
 */
package Double_pointer;

import org.junit.Test;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        //如果是最小的数据都是大于sum 那么就不存在
        if (array.length==0||array[0] > sum) {
            return list;
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            //如果两个数字的和等于的话
            if (array[left] + array[right] == sum) {
                if (list.isEmpty()) {
                    list.add(array[left]);
                    list.add(array[right]);
                } else {
                    if (list.get(0) * list.get(1) > array[left] * array[right]) {
                        list.clear();
                        list.add(array[left]);
                        list.add(array[right]);
                    }
                }
                left++;
                right--;
            }else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] array={};
        ArrayList<Integer> list = FindNumbersWithSum(array, 0);
        for (int V:list){
            System.out.println(V);
        }
    }
}
