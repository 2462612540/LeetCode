/**
 * Copyright (C), 2018-2020
 * FileName: minCostToMoveChips1217
 * Author:   xjl
 * Date:     2020/8/7 8:51
 * Description: 1217. 玩筹码
 */
package leetcode练习题;

public class minCostToMoveChips1217 {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else if (chips[i] % 2 != 0) {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
