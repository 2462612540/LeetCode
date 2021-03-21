package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 数组中出现一次的两个数字
 * @Description TODO
 * @Date 2021/2/26 10:49
 * @Created by xjl
 */
public class 数组中出现一次的两个数字 {

    @Test
    public void test() {
        int[] ints = FindNumsAppearOnce(new int[]{1, 4, 8, 1, 6, 5, 4, 5, 8, 9});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] FindNumsAppearOnce(int[] array) {
        ArrayList<Integer> res = new ArrayList<>();
        //需要遍历两次
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (int a : map.keySet()) {
            if (map.get(a) == 1) {
                res.add(a);
            }
        }
        //这里是的实现的list转为的数组的的函数   res.stream().mapToInt(Integer::intValue).toArray();
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
