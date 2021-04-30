package testcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Classname 幂2
 * @Description TODO
 * @Date 2021/4/16 20:25
 * @Created by xjl
 */
public class 幂2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i = scanner.nextInt();
        boolean res = test(i);
        if (res){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

    }
    public static boolean test(int n){
        if (n==0){
            return false;
        }
        long x=(long) n;
        return (x&(-x))==x;
    }
}
