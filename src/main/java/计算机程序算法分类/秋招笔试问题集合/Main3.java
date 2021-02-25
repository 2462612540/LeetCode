/**
 * Copyright (C), 2018-2020
 * FileName: Main3
 * Author:   xjl
 * Date:     2020/7/15 11:02
 * Description: cheshi
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        //数据输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        String[] arry = sc.nextLine().split(",");
        int[] array2=new int[m];
        for (int i=0;i<m;i++){
            array2[i]=Integer.valueOf(arry[i]);
        }
        //函数的调用
        String result = test(array2);
        //结果的输出
        System.out.println(result);

    }

    private static String test(int[]  list) {
        String[] str_list=new String[list.length];
        String mergeStr="";
        for (int i=0;i<list.length;i++){
            str_list[i]=Integer.toString(list[i]);
        }
        for (int i=0;i<str_list.length-1;i++){
            for (int j=i+1;j<str_list.length;j++){
                String[] str=linkNum(str_list[i],str_list[j]);
                str_list[i]=str[0];
                str_list[j]=str[1];
            }
        }
        for (int i=0;i<str_list.length;i++){
            mergeStr+=str_list[i];
        }
        return mergeStr;
    }

    private static String[] linkNum(String str1, String str2) {
        int min_length=str1.length()<=str2.length()?str1.length():str2.length();
        String[] str3=new String[2];
        str3[0]=str1;
        str3[1]=str2;
        int i=1;
        for (;i<=min_length;i++){
            if(str1.substring(i-1,i).compareTo(str2.substring(i-1,i))<0){
                str3[0]=str2;
                str3[1]=str1;
                break;
            }else if (str1.substring(i-1,i).compareTo(str2.substring(i-1,i))>0){
                break;
            }
        }
        return str3;
    }
}
