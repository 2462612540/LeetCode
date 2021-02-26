package 牛客网名企高频面试题2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 括号的生成问题
 * @Description TODO
 * @Date 2020/12/18 15:13
 * @Created by xjl
 */
public class 括号的生成问题 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>(10);
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String string, int open, int close, int n, List<String> result) {
        if (string.length() == 2 * n) {
            result.add(string);
            return;
        }
        if (open < n) {
            backtrack(string + "(", open + 1, close, n, result);
        }
        if (close < open) {
            backtrack(string + ")", open, close + 1, n, result);
        }
    }
}
