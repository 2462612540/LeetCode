/**
 * Copyright (C), 2018-2020
 * FileName: 英伟达2
 * Author:   xjl
 * Date:     2020/9/7 19:21
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class 英伟达2 {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int count=0;
            int input=sc.nextInt();
            if(input<1||input>100000) return;
            int pr=input/2;
            int ls=input-pr;
            for(int i=0;i<=pr;i++){
                if(isPrime(pr-i)&&isPrime(ls+i))count++;

            }
            System.out.println(count);

        }
    }
    public static boolean isPrime(int num){
        if(num==1||num==2||num==0) return false;
        for(int i=2;i<num;i++)
            if(num%i==0)  return false;
        return true;
    }
}

