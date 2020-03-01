/**
 * Copyright (C), 2018-2020
 * FileName: fastlengthworld
 * Author:   xjl
 * Date:     2020/3/1 10:10
 * Description: 寻找字符创中最长度的单词
 */
package simple_difficulty;

public class fastlengthworld {
    public static  int fastlengthworld(String s) {
        char[] char1=s.toCharArray();
        int result=0;
        int count=0;
        for(int i=0;i<char1.length;i++){
            //判断是这个是否为空和最后一个
            if(i<char1.length){
                if(!(char1[i]==' ')){
                    count++;
                }else {
                    if(count>result){
                        result=count;
                    }
                    count=0;
                }
            }else {
                if(count>result){
                    return result=count;
                }
            }
        }
        if(count>result){
            result=count;
            return result;
        }else {
            return result;
        }
    }
}
