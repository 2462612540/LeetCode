package 牛客网名企高频面试题复现代码2021;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 括号的生成
 * @Description TODO
 * @Date 2021/2/26 9:40
 * @Created by xjl
 */
public class 括号的生成 {

    @Test
    public void test(){
        ArrayList<String> strings = generateParenthesis(2);
        for (String s:strings){
            System.out.println(s);
        }
    }

    public ArrayList<String> generateParenthesis(int n){
        ArrayList<String> res=new ArrayList<>();
        dfs(res,new StringBuilder(),0,0,n);
        return res;
    }

    private void dfs(ArrayList<String> res, StringBuilder str, int left, int right, int n) {
        //定义终止条件
        if (str.length()==2*n){
            res.add(str.toString());
            return;
        }
        //先定义左边的括号
        if (left<n){
            str.append("(");
            dfs(res,str,left+1,right,n);
            str.deleteCharAt(str.length()-1);
        }
        //在定义右边括号
        if (right<left){
            str.append(")");
            dfs(res,str,left,right+1,n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
