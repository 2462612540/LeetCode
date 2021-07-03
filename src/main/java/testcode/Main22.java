package testcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname Main22
 * @Description TODO
 * @Date 2021/6/17 20:23
 * @Created by xjl
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int number = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("7") || Long.valueOf(s[i]) % 7 == 0) {
                number++;
            }
        }
        if (number != 0) {
            System.out.println(number);
        } else {
            System.out.println(0);
        }
    }
}
