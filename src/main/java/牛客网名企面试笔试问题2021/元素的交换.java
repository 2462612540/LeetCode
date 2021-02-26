package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname 元素的交换
 * @Description TODO
 * @Date 2021/2/26 13:30
 * @Created by xjl
 */
public class 元素的交换 {

    public int[] sovle(int[] a, int n, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int temp = a[map.get(list.get(a.length - m))];
        a[map.get(list.get(a.length - m))] = a[map.get(list.get(a.length - n))];
        a[map.get(list.get(a.length - n))] = temp;
        return a;
    }

    @Test
    public void test() {
        int[] sovle = sovle(new int[]{1, 2, 3}, 1, 2);
        for (int i : sovle) {
            System.out.print(i + " ");
        }
    }

    /**
     * @description TODO  不用其他的额外的空间来实现的是交换a b的两个数
     * @param: a
     * @param: b
     * @date: 2021/2/26 13:50
     * @return: void
     * @author: xjl
     */
    public void change(int a, int b) {
        System.out.println(a+"----"+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a+"----"+b);
    }

    @Test
    public void test1() {
        change(2, 3);
    }

}
