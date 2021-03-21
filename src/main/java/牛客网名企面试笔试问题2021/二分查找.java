package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname 二分查找
 * @Description TODO
 * @Date 2021/3/8 9:40
 * @Created by xjl
 */
public class 二分查找 {
    @Test
    public void test() {
        int search = search1(new int[]{1, 2, 2, 3, 4}, 2);
        System.out.println(search);
    }
    /**
     * @description TODO  没有重复的查找
      * @param: nums
     * @param: target
     * @date: 2021/3/8 9:52
     * @return: int
     * @author: xjl
    */
    public int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i;
    }
    /**
     * @description TODO 有重复的查找
     * @param: nums
     * @param: target
     * @date: 2021/3/8 9:53
     * @return: int
     * @author: xjl
    */
    public int search1(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        while (i > 0) {
            if (nums[i]!=nums[i-1]){
               break;
            }
            i--;
        }
        return i;
    }
}
