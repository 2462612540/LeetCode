/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package Test_Pricate;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入的数量
        String str=sc.nextLine();
        int k=sc.nextInt();

        int left=0;
        int right=str.length();
        int index=1;
        while (k>0){
            str=str.substring(left,right);
            if (index%2!=0){
                left++;
            }
            else {
                right--;
            }
            k--;
            index++;
        }
        System.out.println(str);
    }
}

