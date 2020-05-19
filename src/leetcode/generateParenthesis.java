/**
 * Copyright (C), 2018-2020
 * FileName: generateParenthesis
 * Author:   xjl
 * Date:     2020/3/27 19:43
 * Description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。  例如，给出 n = 3，生成结果为：
 */
package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');

        return null;
    }

    @Test
    public void test() {
        generateParenthesis(3);
    }
}
