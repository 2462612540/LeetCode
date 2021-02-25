package 牛客网名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 数组中的逆序数对
 * @Description TODO 在数组中的两个数字，如果前面一个数字大于后面的数字（发现一个后面的数字），则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @Date 2020/12/8 14:01
 * @Created by xjl
 */
public class 数组中的逆序数对 {
    /**
     * @description TODO 采用的逆序数对 采用的是的遍历的方式 但是这样的方式超时
     * @param: array
     * @date: 2020/12/8 14:05
     * @return: int
     * @author: xjl
     */
    public int InversePairs(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }

    /**
     * @description TODO 采用了的数组归并的方式来实现的
     * @param: nums
     * @date: 2020/12/8 15:31
     * @return: int
     * @author: xjl
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
                count += (right - mid);
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
                count += (j - mid - 1);
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int i = InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0});
        System.out.println(i);
    }
}
