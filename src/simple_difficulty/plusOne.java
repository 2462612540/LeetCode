/**
 * Copyright (C), 2018-2020
 * FileName: plusOne
 * Author:   xjl
 * Date:     2020/3/1 11:02
 * Description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。  最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。  你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
package simple_difficulty;

/**
 * 1 需要考录是的加1后数字突破了原来的存储范围99+1
 *
 */

public class plusOne {
    public static int[] plusOne(int[] digits) {
        int flag=0;
        int n=digits.length;
        if(digits.length==1){
            if(digits[0]+1==10){
                int[] newdigits=new int[2];
                newdigits[0]=1;
                newdigits[1]=0;
                return newdigits;
            }else {
                digits[0]=digits[0]+1;
            }
            return digits;
        }
        if(digits[digits.length-1]+1==10){
            flag=1;
            digits[digits.length-1]=0;
            //判断最后一位加一后是否是等于10的 这个判断的条件有问题，不能设置为从第二个开始中短的条件
            for(int i=digits.length-2;i>=0;i--){
                if(digits[i]+flag==10){
                    //等于10
                    flag=1;
                    digits[i]=0;
                }else {
                    //不等于10的话
                    flag=0;
                    digits[i]+=1;
                    break;
                }
                if(flag==1&&digits[0]==0){
                    //新来一个数组赋值
                    int[] newdigits=new int[n+1];
                    newdigits[0]=1;
                    for (int j=1;j<newdigits.length;j++){
                        newdigits[j]=0;
                    }
                    return newdigits;
                }
            }
        }else {
            digits[digits.length-1]+=1;
        }
        return digits;
    }
    public static int[] plusOne2(int[] digits){
        int flag=0;
        for(int i=digits.length-1;i>=0;i++){
            if(digits[i]+flag==10);
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] array={8};
        int[] res=plusOne(array);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
