package 计算机程序算法分类.dfs深度优先广度优先问题;

import 牛客网练习题.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 电话号码的字母组合17
 * @Description TODO
 * @Date 2021/4/11 10:42
 * @Created by xjl
 */
public class 电话号码的字母组合17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        //index 表示的是访问位置的第几个
        backtrack(result, phoneMap, digits, 0, new StringBuffer());
        return result;
    }

    public void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            //表示的是第几个数字
            char digit = digits.charAt(index);
            //获取对应的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                //添加当前的字母
                sb.append(letters.charAt(i));
                //递归到下一个
                backtrack(result, phoneMap, digits, index + 1, sb);
                //回溯算法进行
                sb.deleteCharAt(index);
            }
        }
    }
}
