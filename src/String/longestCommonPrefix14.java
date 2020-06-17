/**
 * Copyright (C), 2018-2020
 * FileName: longestCommonPrefix14
 * Author:   xjl
 * Date:     2020/6/15 8:47
 * Description: 最长公共字符串
 */
package String;

import java.util.Arrays;

public class longestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        //就是将字符串进行排序
        if (strs == null || strs.length == 0) return "";
        //然后比较第一个和最后一个字符匹配就可以啦
        Arrays.sort(strs);
        String world1 = strs[0];
        String world2 = strs[strs.length - 1];
        while (world2.indexOf(world1) != 0) {
            world1 = world1.substring(0, world1.length() - 1);
        }
        return world1;
    }

}
