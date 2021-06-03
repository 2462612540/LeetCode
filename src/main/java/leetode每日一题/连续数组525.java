package leetode每日一题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 连续数组525
 * @Description TODO
 * @Date 2021/6/3 10:07
 * @Created by xjl
 */
public class 连续数组525 {

    @Test
    public void test() {
        int maxLength = findMaxLength(new int[]{0, 1, 0});
    }

    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//存储的是前缀和该位置的下标是
        int counter = 0;//表示的前缀和
        map.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            counter = nums[i] == 1 ? counter++ : counter--;
            if (map.containsKey(counter)) {
                maxLength = Math.max(maxLength, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
