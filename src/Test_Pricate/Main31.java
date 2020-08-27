/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package Test_Pricate;

import java.util.ArrayList;
import java.util.Scanner;

public class Main31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        String str = sc.nextLine().replace("[",",").replace("]",",");
        String[] array=str.split(",");

        for (int i=0;i<array.length;i++){
            if (array[i].equals("")){
                continue;
            }else {
                list.add(Integer.valueOf(array[i]));
            }
        }
        for (int i = 1; i < list.size() / 2; i++) {
            list2.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            list3.add(list.get(i));
        }

        Math.abs(sc.nextInt());

        int ans = test(list2, list3);
        System.out.println(ans);
    }

    private static int test(ArrayList<Integer> list2, ArrayList<Integer> list3) {
        int sum = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i) < 1 || list2.get(i) > 100) {
                return 0;
            }
            sum++;
        }
        System.out.println(sum);
        //如果快
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list2.get(i); j++) {
                list.add(list3.get(i));
            }
        }
        System.out.println(list.toString());
        return 0;
    }
}

