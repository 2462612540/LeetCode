/**
 * Copyright (C), 2018-2020
 * FileName: divingBoard
 * Author:   xjl
 * Date:     2020/3/4 15:33
 * Description: 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/diving-board-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class divingBoard {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Set<Double> set = new HashSet();
        double sum = 0;
        for (int i = 0; i <= k; i++) {
            sum = shorter * i + longer * (k - i);
            if (!set.contains(sum)) {
                set.add(sum);
            }
        }
        int[] res = new int[set.size()];
        int j = 0;
        for (Double value : set) {
            res[j] = new Double(value).intValue();
            j++;
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int shorter = 2, longer = 1118596, k = 979;
        divingBoard(shorter, longer, k);
    }
}
