package leetode每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname 判断数组为和谐数组
 * @Description TODO
 * @Date 2021/5/9 15:20
 * @Created by xjl
 */
public class 判断数组为和谐数组 {

    public static void main(String[] args) {
        int[] array = new int[14];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 14; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        boolean res = testarrray(array);
    }

    /**
     * @description TODO  4组合1对
     * @param: array
     * @date: 2021/5/9 15:23
     * @return: boolean
     * @author: xjl
     */
    private static boolean testarrray(int[] array) {
        return false;
    }
}
