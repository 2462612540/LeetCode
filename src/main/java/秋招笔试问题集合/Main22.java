/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main22 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int[] arr = new int[n + 1];
            String[] strs = br.readLine().split(" ");
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i - 1]);
            }
            int m = Integer.parseInt(br.readLine());
            int res = solution(arr, n);
            if (res <= m) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    private static int solution(int[] arr, int n) {
        Arrays.sort(arr);
        int sum = 0;
        while (n > 0) {
            if (n == 1) {
                sum += arr[1];
                break;
            } else if (n == 2) {
                sum += arr[2];
                break;
            } else if (n == 3) {
                sum += arr[1] + arr[2] + arr[3];
                break;
            } else {
                if (arr[n - 1] + arr[1] <= 2 * arr[2]) {
                    sum += arr[n] + arr[n - 1] + 2 * arr[1];
                } else {
                    sum += arr[n] + arr[1] + 2 * arr[2];
                    n -= 2;
                }
            }
        }
        return sum;
    }

}

