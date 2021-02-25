/**
 * Copyright (C), 2018-2020
 * FileName: isUnique
 * Author:   xjl
 * Date:     2020/3/4 8:28
 * Description: 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
package 牛客网练习题;

import java.util.HashMap;
import java.util.Map;

public class isUnique {
    public boolean isUnique(String astr) {
        char[] c=astr.toCharArray();
        Map<Integer,Character> map=new HashMap();
        for(int i=0;i<c.length;i++){
            if(!map.containsValue(c[i])){
                map.put(i,c[i]);
            }
        }
        if(map.size()==c.length){
            return true;
        }else {
            return false;
        }
    }
}
