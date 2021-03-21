package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 括号的生成
 * @Description TODO
 * @Date 2021/2/25 20:54
 * @Created by xjl
 */
public class 括号的生成 {

    @Test
    public void test(){
        generateParenthesis(2);
    }

    public ArrayList<String> generateParenthesis2 (int n) {
        ArrayList<String> ans = new ArrayList<String>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    /**
     * @description TODO  使用的是的回溯的思想来构造这样的一个  就是一个二叉树的的剪枝思想
      * @param: ans
      * @param: cur
      * @param: left
      * @param: right
      * @param: max
      * @date: 2021/2/25 21:32
      * @return: void
      * @author: xjl
    */
    public void dfs(List<String> ans, StringBuilder cur, int left, int right, int max) {
        //判断是的字符串的长度的以便于终止函数的跳出
        if (cur.length() == max * 2) {
            //添加到结果集中
            ans.add(cur.toString());
            return;
        }
        //左边的小于最大值得时候就加入左括号
        if (left < max) {
            cur.append('(');
            dfs(ans, cur, left + 1, right, max);
            //这里使用了回溯的方法 删除最后的一个
            cur.deleteCharAt(cur.length() - 1);
        }
        //当右边的小于左边的时候加入右边括号
        if (right < left) {
            cur.append(')');
            dfs(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

