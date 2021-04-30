package testcode;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname testcode.test.test
 * @Description TODO
 * @Date 2021/2/25 19:57
 * @Created by xjl
 */
public class test {

    static int calcSimilarity(String name1, String name2) {
        String[] s1 = name1.split(" ");
        String[] s2 = name2.split(" ");

        int i = 0, j = 0;
        int result = 0;
        while (i < s1.length && j < s2.length) {
            result += min(s1[i], s2[j]);
            i++;
            j++;
        }
        while (j < s2.length) {
            int sum = 0;
            for (int x = 0; x < s2[j].length(); x++) {
                sum += s2[j].charAt(x);
            }
            result += sum;
            j++;
        }
        while (i < s1.length) {
            int sum = 0;
            for (int x = 0; x < s1[i].length(); x++) {
                sum += s1[i].charAt(x);
            }
            result += sum;
            i++;
        }
        return result;
    }

    public static int min(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.codePointAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j + 1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String name2 = in.nextLine();

            int sum = calcSimilarity(name1, name2);
            System.out.println(sum);
        }
    }

    @Test
    public void test() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);

        StringBuffer stringBuffer = new StringBuffer();
    }

    @Test
    public void test2() {
        Double[] arr = {98.0, 99.00, 80.0, 75.0, 60.0};
        float[] arr1 = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = Float.valueOf(String.valueOf(arr[i]));
        }
        float v = calAverageScore(arr1);
        System.out.println(v);

    }

    public float calAverageScore(float[] scores) {
        return 0;
    }

    @Test
    public void test3() {
        // TODO Auto-generated method stub
        long sum = 1;
        long func = 1;
        for (int i = 2; i <= 20; i++) {
            func = func * i;
            sum += func;
        }
        System.out.println(sum);
    }

    @Test
    public void test4() {
        // TODO Auto-generated method stub
        long sum = 1;
        long func = 1;
        for (int i = 1; ; i++) {
            if (i % 2 == 1 && i % 3 == 2 && i % 5 == 4 && i % 6 == 5 && i % 7 == 0) {
                System.out.println(i);
                return;
            }
        }
    }

    @Test
    public void test5() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        list.add(new int[]{6, 7});
        list.add(new int[]{8, 9, 10, 11});
        int sum = 0;
        for (int[] arr : list) {
            for (int a : arr) {
                sum += a;
                System.out.print(a + " ");
            }
        }
        System.out.println(sum);
    }
}
