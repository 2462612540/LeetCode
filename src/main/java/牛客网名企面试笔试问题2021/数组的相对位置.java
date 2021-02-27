package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 数组的相对位置
 * 　具有稳定性的排序算法有：
 *
 *     冒泡排序
 *     归并排序
 *     基数排序
 *     直接插入排序
 *     这般插入排序
 *
 * 　　不稳定性的排序算法有：
 *
 *     堆排序
 *     快速排序
 *     希尔排序
 *     直接选择排序
 * @Description TODO
 * @Date 2021/2/27 12:29
 * @Created by xjl
 */
public class 数组的相对位置 {

    @Test
    public void test() {
        int[] res = reOrderArray(new int[]{1, 2, 4, 3});
        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 采用的是冒泡排序的方法
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray(int[] array) {
        // bubble sort
        if (array == null || array.length == 0) return new int[0];
        int n = array.length;
        //冒泡排序的原理
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                // 左边是偶数, 右边是奇数的情况  x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static void reOrderArray3(int[] array) {
        int brace = -1;
        int ptr = 0;
        while (ptr < array.length) {
            if (array[ptr] % 2 == 0) {
                ptr++;
                continue;
            }
            swap(array, ptr++, ++brace);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 但是这个函数不要求的相位的位置的不变
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            //x&1 位运算 等价于 x%2x \% 2x%2 取余运算，即皆可用于判断数字奇偶性。
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public int[] reOrderArray1(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }
        for (int i : even) {
            odd.add(i);
        }
        return odd.stream().mapToInt(Integer::intValue).toArray();
    }

}
