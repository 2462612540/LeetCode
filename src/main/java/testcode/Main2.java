package testcode;

import 牛客网练习题.Solution;

import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2021/4/26 21:10
 * @Created by xjl
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        java.lang.String string=scanner.nextLine();
        String s = replaceSpace(string);
        System.out.println(s);

    }
    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
