/**
 * Copyright (C), 2018-2020
 * FileName: findMagicIndex
 * Author:   xjl
 * Date:     2020/7/31 19:30
 * Description:
 */
package Array;

import org.junit.Test;

public class findMagicIndex {
    /**
     * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i
     *
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] array = {1,1,1};
        int index = findMagicIndex(array);
        System.out.println(index);
    }
}
