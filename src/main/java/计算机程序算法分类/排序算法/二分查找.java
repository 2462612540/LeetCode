package 计算机程序算法分类.排序算法;

import java.util.Arrays;

/**
 * @Classname 二分查找
 * @Description TODO
 * @Date 2021/3/23 11:56
 * @Created by xjl
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = Arrays.binarySearch(arr, 12);//这个JDk提供的函数方法
        System.out.println(MyBinarySearch(arr, 40));
    }

    public static int MyBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;//这样不会出现溢出的问题
            if (value == arr[mid]) {
                return mid + 1;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;//没有找到返回-1
    }
}
