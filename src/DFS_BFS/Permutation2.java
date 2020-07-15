/**
 * Copyright (C), 2018-2020
 * FileName: Permutation2
 * Author:   xjl
 * Date:     2020/7/15 16:21
 * Description: quanpailie
 */
package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Permutation2 {

    public ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        slove(array, result, 0, str.length());
        result=new ArrayList<>(new HashSet<String>(result));//除重复操作
        Collections.sort(result);
        return result;
    }

    private void slove(char[] array, ArrayList<String> result, int index, int length) {
        if (index == length - 1) {
            String res = chage(array);
            result.add(res);
        } else {
            //说明要去确定indxd的位置
            for (int i = index; i < length; i++) {
                char temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                //那么就是递归的调用到洗衣歌位置的字符
                slove(array, result, index + 1, length);
                //为了消除递归的时候的进行的交换的字符的影响
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    private String chage(char[] array) {
        StringBuilder res = new StringBuilder();
        for (char value : array) {
            res.append(value);
        }
        return res.toString();
    }

}
