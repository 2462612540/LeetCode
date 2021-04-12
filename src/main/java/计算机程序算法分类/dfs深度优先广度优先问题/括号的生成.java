package 计算机程序算法分类.dfs深度优先广度优先问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 括号的生成  回溯算法事实上就是在一个树形问题上做深度优先遍历
 * @Description TODO
 * @Date 2021/4/11 15:50
 * @Created by xjl
 */
public class 括号的生成 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, 0, 0, n);
        return result;
    }

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
