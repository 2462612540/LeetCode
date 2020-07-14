/**
 * Copyright (C), 2018-2020
 * FileName: Main4
 * Author:   xjl
 * Date:     2020/7/13 19:47
 * Description: 排序算法
 */
package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int len = Integer.valueOf(str[0]);
        String[] arrStr = reader.readLine().split(" ");
        int[] arr = new int[arrStr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(findUnsortedSubarray(arr));
    }

    public static int findUnsortedSubarray(int[] arr) {
        if(arr == null || arr.length == 0 || arr.length == 1)
            return 0;

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            max = Math.max(arr[i], max);
            if(arr[i] < max) right = i;
        }

        for(int j=arr.length-1; j>=0; j--) {
            min = Math.min(arr[j], min);
            if(arr[j] > min) left = j;
        }
        return right - left + 1;
    }
}
