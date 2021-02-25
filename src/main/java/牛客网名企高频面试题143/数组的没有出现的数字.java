package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.数组的没有出现的数字
 * Author:   xjl
 * Date:     2020/10/1 11:49
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 数组的没有出现的数字 {

    @Test
    public void test() {
        int i = minNumberdisappered2(new int[]{1, 2, 6, 4});
        System.out.println(i);
    }

    public int minNumberdisappered2(int[] arr) {
        int n = arr.length;
        int falg = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                falg = 2;
                break;
            }
        }
        if (falg == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(arr[i]) -1;
            arr[a] = -Math.abs(arr[a]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }

    public int minNumberdisappered1(int[] arr) {
        if (arr.length == 0) {
            return 1;
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(i + 1, arr[i]);
            }
            for (int i = 1; i < arr.length + 2; i++) {
                if (!map.containsValue(i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * 超过时间复杂度
     *
     * @param arr
     * @return
     */
    public int minNumberdisappered(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }
}
