/**
 * Copyright (C), 2018-2020
 * FileName: intToRoman
 * Author:   xjl
 * Date:     2020/3/20 12:38
 * Description: 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class intToRoman {
    public String intToRoman(int num) {
        Map map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 1);
        map.put("X", 1);
        map.put("L", 1);
        map.put("C", 1);
        map.put("D", 1);
        map.put("M", 1);

        return null;
    }

    @Test
    public void test() {

    }
}
