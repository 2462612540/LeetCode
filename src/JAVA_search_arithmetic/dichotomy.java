/**
 * Copyright (C), 2018-2020
 * FileName: dichotomy
 * Author:   xjl
 * Date:     2020/3/4 17:45
 * Description: 实现的是二分法的查找技术
 */
package JAVA_search_arithmetic;

public class dichotomy {
    /**
     * 实现的是二分法的查找功能 二分法的前提是需要将数组进行的有序的排序
     */
    public static int dichotomy(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target == numbers[mid]) {
                return mid;
            }
            if (target > numbers[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 利用递归来实现的二分查找
     *
     * @return
     */
    public static int binarySearch(int[] data, int target, int start, int end) {
        //将不满足的情况排除在外及时的防止栈溢出的情况
        if (target < data[start] || target > data[end] || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target < data[mid]) {
            return binarySearch(data, target, start, mid - 1);
        } else if (target > data[mid]) {
            return binarySearch(data, target, mid + 1, end);
        } else {
            return mid;
        }
    }

    /**
     * 利用的是hash的思想来进行的查询
     */
    public static Boolean Hashsearch(int[] data, int target) {
        //新的数组将来是的大于的data最大的数字
        int[] n = new int[100];
        for (int i = 0; i < data.length; i++) {
            n[data[i]] = 1;
        }
        if (n[target] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 53, 69, 86, 98};
        int target = 86;
//        System.out.println(dichotomy(numbers, target));
        System.out.println(Hashsearch(numbers, target));
    }
}
