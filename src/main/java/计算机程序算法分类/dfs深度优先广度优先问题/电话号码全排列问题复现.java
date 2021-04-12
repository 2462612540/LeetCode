package 计算机程序算法分类.dfs深度优先广度优先问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 电话号码全排列问题复现
 * @Description TODO
 * @Date 2021/4/11 14:57
 * @Created by xjl
 */
public class 电话号码全排列问题复现 {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        //开始访问的位置
        int index = 0;
        //存储电话号码的映射
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //进行的递归的方法
        dfs2(result, map, digits, index, new StringBuilder());
        return result;
    }

    private void dfs(ArrayList<String> result, Map<Character, String> map, String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        } else {
            char digit = digits.charAt(index);
            //获取当前的字符串
            String number = map.get(digit);
            for (int i = 0; i < number.length(); i++) {
                //添加
                stringBuilder.append(number.charAt(i));
                //递归调用
                dfs(result, map, digits, index + 1, stringBuilder);
                //回溯
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    private void dfs2(ArrayList<String> result, Map<Character, String> map, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        } else {
            char ch = digits.charAt(index);
            String str = map.get(ch);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                dfs2(result, map, digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        List<String> strings = letterCombinations("23");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
