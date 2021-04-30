package testcode;

import leetcode练习题.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname 全排列
 * @Description TODO
 * @Date 2021/4/16 20:09
 * @Created by xjl
 */
public class 全排列 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        ArrayList<String> permutation = Permutation(str);
        Collections.sort(permutation);
        StringBuilder res=new StringBuilder();
        for (String s:permutation){
            res.append("'");
            res.append(s);
            res.append("'");
            res.append(",");
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        System.out.println("["+res.toString()+"]");
    }
    public static ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        slove(array, result, 0, str.length());
        return result;
    }

    private static void slove(char[] array, ArrayList<String> result, int index, int length) {
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
    private static String chage(char[] array) {
        StringBuilder res = new StringBuilder();
        for (char value : array) {
            res.append(value);
        }
        return res.toString();
    }

}
