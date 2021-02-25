package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.只出现一次的数字
 * Author:   xjl
 * Date:     2020/9/24 12:50
 * Description:
 */


import java.util.HashMap;

public class 只出现一次的数字 {
    /**
     * 使用最基本的方法来实现
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int count = 1;
        for (int i : map.keySet()) {
            if (count == 1 && map.get(i) == 1) {
                num1[0] = i;
                count = 2;
            } else if (count == 2 && map.get(i) == 1) {
                num2[0] = i;
            }
        }
    }
}
