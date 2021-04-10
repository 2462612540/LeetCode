package 计算机程序算法分类.二分查找问题;

import org.junit.Test;

/**
 * @Classname 二分查找
 * @Description TODO
 * @Date 2021/4/10 14:37
 * @Created by xjl
 */
public class 二分查找 {
    /**
     * @description TODO 这里指的是的目标的位置 且元素是不重复的
     * @param: numbers
     * @param: target
     * @date: 2021/4/10 14:42
     * @return: int
     * @author: xjl
     */
    public int binsearch(int[] numbers, int target) {
        if (numbers.length < 0) return -1;
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid + 1;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -numbers.length;
    }

    /**
     * @description TODO 如果元素是重复的的话 也是可以采用的二分查找的
     * @param: numbers
     * @param: target
     * @date: 2021/4/10 14:43
     * @return: int
     * @author: xjl
     */
    public int binsearch2(int[] numbers, int target) {
        if (numbers.length < 0) return -1;
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        //这里进行的二分的查找的
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //找到的原来数组的中的最小的一个的
        while (mid >= 1) {
            if (numbers[mid - 1] == numbers[mid]) {
                mid--;
            } else {
                break;
            }
        }
        return mid;

    }

    @Test
    public void test() {
        int search = binsearch2(new int[]{1, 2, 3, 3, 3, 4, 5, 9, 45}, 3);
        System.out.println(search);
    }
}
