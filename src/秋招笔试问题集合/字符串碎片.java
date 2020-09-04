package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.List;

public class 字符串碎片 {

    public int GetFragment(String str) {
        if (str==null&&str.length()==0){
           return 0;
        }
        List<Integer> res=new ArrayList<>();
        char[] strChar=str.toCharArray();
        int len=str.length();
        int index=0;
        while (index<len){
            int fistchar=strChar[index];
            int num=0;
            while (strChar[index]==fistchar){
                index++;
                num++;
                if (index==len){
                    break;
                }
            }
            res.add(num);
        }
        int size=res.size();
        int sum=0;
        for (Integer in:res){
            sum=sum+in;
        }
        return sum/size;
    }
}
