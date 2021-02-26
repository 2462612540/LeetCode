package 牛客网名企面试笔试代码复现2021;

import java.util.ArrayList;

/**
 * @Classname 括号的生成
 * @Description TODO
 * @Date 2021/2/26 10:11
 * @Created by xjl
 */
public class 括号的生成 {
    public ArrayList<String> generate(int n){
        ArrayList<String> res=new ArrayList<>();
        dfs(res,new StringBuilder(),0,0,n);
        return res;
    }
    /**
     * @description TODO 才是的递归加上的剪枝算法
      * @param: res
     * @param: str
     * @param: left
     * @param: right
     * @param: n
     * @date: 2021/2/26 10:15
     * @return: void
     * @author: xjl
    */
    private void dfs(ArrayList<String> res, StringBuilder str, int left, int right, int n) {
        if (str.length()==2*n){
            res.add(str.toString());
            return;
        }
        if (left<n){
            str.append("(");
            dfs(res,str,left+1,right,n);
            str.deleteCharAt(str.length()-1);
        }
        if (right<left){
            str.append(")");
            dfs(res,str,left,right+1,n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
