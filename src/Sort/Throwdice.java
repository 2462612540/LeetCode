/**
 * Copyright (C), 2018-2020
 * FileName: Throwdice
 * Author:   xjl
 * Date:     2020/7/5 21:12
 * Description:  牛妹在和牛牛玩扔骰子，他们的游戏规则有所不同； 每个人可以扔nnn次mmm面骰子，来获得nnn个数 得分为任意选取nnn个数中的某些数求和所不能得到的最小的正整数 得分大的人获胜 例如扔骰子333次得到了 1 11 222 55 5，那么这个人的得分是444 牛妹想知道这回合她是否能赢 牛妹的n个数存在数组a中，牛牛的n个数存在数组b中  数组下标从0开始
 */
package Sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Throwdice {
    public String Throwdice(int n, int m, int[] a, int[] b) {
        int n1 = cul(n, m, a);
        int n2 = cul(n, m, b);
        if (n1 > n2) {
            return "Happy";
        } else {
            return "Sad";
        }
    }

    private int cul(int n, int m, int[] a) {
        int max = m * n;
        ArrayList<Integer> list = new ArrayList<>();
        //添加元素到list
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        //计算包含的值
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (!list.contains(a[i] + a[j]) && (a[i] + a[j]) <= max) {
                    list.add(a[i] + a[j]);
                }
            }
        }
        //开始计算最小的值
        for (int i = 1; i <= max; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public String Throwdice2(int n, int m, int[] a, int[] b) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        long a1 = Num(a, n);
        long b1 = Num(b, n);
        return a1 > b1 ? "Happy" : "Sad";
    }

    public long Num(int[] t, int n) {
        long num = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] > num + 1){
                break;
            }
            num += t[i];
        }
        return num;
    }

    @Test
    public void test() {
        int[] a = {4, 9, 7, 10, 3, 7, 8, 4, 6, 6, 3, 10, 9, 3, 5, 9, 1, 8, 3, 2};
        int[] b = {9, 9, 8, 2, 6, 7, 4, 8, 10, 1, 6, 5, 3, 3, 6, 2, 4, 6, 4, 3};

        String throwdice = Throwdice2(20, 10, a, b);
        System.out.println(throwdice);

    }

}
