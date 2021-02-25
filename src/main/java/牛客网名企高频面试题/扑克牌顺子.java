package 牛客网名企高频面试题;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Classname 扑克牌顺子
 * @Description TODO
 * @Date 2020/12/15 14:23
 * @Created by xjl
 */
public class 扑克牌顺子 {
    /**
     * @description TODO 使用的是排序数组 然后判断0的个数，在是否有多余0的次数
     * @param: numbers
     * @date: 2020/12/15 14:26
     * @return: boolean
     * @author: xjl
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int num = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                num++;
            } else {
                if (numbers[i + 1] == numbers[i]) {
                    return false;
                }
                if (numbers[i + 1] != numbers[i] + 1) {
                    num -= numbers[i + 1] - numbers[i] - 1;
                }
            }
        }
        return num >= 0;
    }

    public boolean IsContinuous(int[] numbers) {
        if (numbers.length == 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int val : numbers) {
            if (val > 0) {
                if (set.contains(val)) return false;
                set.add(val);
            }
        }
        return set.last() - set.first() < 5;
    }

    @Test
    public void test() {
        boolean res = isContinuous(new int[]{0, 0, 1, 0, 1});
        System.out.println(res);
    }
}
