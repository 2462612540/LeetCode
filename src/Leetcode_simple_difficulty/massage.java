/**
 * Copyright (C), 2018-2020
 * FileName: massage
 * Author:   xjl
 * Date:     2020/3/24 18:28
 * Description: 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/the-masseuse-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

public class massage {

    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    @Test
    public void test() {
        int[] numbers = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(massage(numbers));
    }
}
