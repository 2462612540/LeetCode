package testcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/3/24 15:44
 * @Created by xjl
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                list.add(Integer.valueOf(s.charAt(i)-'0'));
            }
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int[] result = test11(array);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    private static int[] test11(int[] digits) {
        int len=digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
