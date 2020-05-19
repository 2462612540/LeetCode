/**
 * Copyright (C), 2018-2020
 * FileName: Permutation
 * Author:   xjl
 * Date:     2020/5/17 14:35
 * Description: 全排列
 */
package NiuKeCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    ArrayList<String> lists = new ArrayList<>();
    Boolean[] used;

    public void generatepermuation(char[] nums, String str) {
        if (str.length() == nums.length) {
            lists.add(str);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                str += nums[i];
                used[i] = true;
                generatepermuation(nums, str);
                str = str.substring(0, str.length() - 1);
                used[i] = false;
            }
        }
        return;
    }

    public ArrayList<String> Permutation1(String str) {
        char[] array = str.toCharArray();
        if (array.length == 0) {
            return lists;
        }
        used = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            used[i] = false;
        }
        generatepermuation(array, "");
        return lists;
    }

    public ArrayList<String> Permutation(String str)
    {
        ArrayList<String> res=new ArrayList<String>();
        if(str.length()==0||str==null)return res;
        int n= str.length();
        helper(res,0,str.toCharArray());
        Collections.sort(res);
        for (String s : res) {
            System.out.println(s);
        }
        return res;

    }
    public void helper( ArrayList<String> res,int index,char []s)
    {
        if(index==s.length-1)res.add(new String(s));
        for(int i=index;i<s.length;i++)
        {
            if(i==index||s[index]!=s[i])
            {
                swap(s,index,i);
                helper(res,index+1,s);
                swap(s,index,i);
            }
        }

    }

    public void swap(char[]t,int i,int j)
    {
        char c=t[i];
        t[i]=t[j];
        t[j]=c;
    }

    @Test
    public void test() {
        String str = "aa";
        Permutation(str);
        for (String s : lists) {
            System.out.println(s);
        }
    }
}
