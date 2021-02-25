package leetcode练习题;

/**
 * Copyright (C), 2018-2019
 * FileName: leetcode.convert
 * Author:   xjl
 * Date:     2019/10/28 8:20
 * Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */

public class convert {
    public static String convert(String s, int numRows) {
        char[] data = s.toCharArray();
        char[][] res = new char[numRows][9];
        int x = 0, y = 0;
        for (int i = 0; i < data.length; i++) {
            res[x][y] = data[i];
            if (x<numRows) {
                x++;
            }else {
                x--;
                while (x>0){
                    x--;
                    y++;
                    if(i==data.length){
                        break;
                    }
                    res[x][y]=data[i++];
                }
                i-=2;
            }
        }
        for (char[] cells : res) {
            for (char cell : cells) {
                System.out.print(cell);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
    }
}
