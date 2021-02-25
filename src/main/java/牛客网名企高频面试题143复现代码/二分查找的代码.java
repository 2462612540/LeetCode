package 牛客网名企高频面试题143复现代码;

import org.junit.Test;

/**
 * @Classname 二分查找的代码
 * @Description TODO
 * @Date 2020/12/10 16:30
 * @Created by xjl
 */
public class 二分查找的代码 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binserch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int index = search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        System.out.println(index);
    }

    public static void main(String[] args) {
        test2();
    }

    public static int test2() {
        try {
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 2;
        }
    }

}
