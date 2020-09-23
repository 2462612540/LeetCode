/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.math.BigDecimal;

public class String转Double的问题 {

    public static void main(String[] args) {
        BigDecimal sum3 = new BigDecimal("0.21").add(new BigDecimal("0.02"));
        System.out.println(sum3);
    }

    public static void test() {
        String s1 = "0.99";
        String s2 = "0.886";
        String[] shuZi1 = null, shuZi2 = null;
        int num1 = 0, num10 = 0, num2 = 0, num20 = 0;
        int shuZi1xiaoShuChangDu = 0, shuZi2xiaoShuChangDu = 0;
        Integer xiaoShuHe = 0, numHe = 0;
        double zongHe = 0.0;
        String jinWei = "0";
        //判断s1,s2是否有小数位
        if (s1.indexOf(".") != -1) {
            shuZi1 = s1.split("\\.");
            num1 = Integer.valueOf(shuZi1[0]);
            num10 = Integer.valueOf(shuZi1[1]);
        } else {
            num1 = Integer.valueOf(s1);
        }
        if (s2.indexOf(".") != -1) {
            shuZi2 = s2.split("\\.");
            num2 = Integer.valueOf(shuZi2[0]);
            num20 = Integer.valueOf(shuZi2[1]);
        } else {
            num2 = Integer.valueOf(s2);
        }
        //计算小数位,短的数要乘上对应的10才可和长的数同级相加
        if (num10 != 0 && num20 != 0) {
            if (shuZi1[1].length() > shuZi2[1].length()) {
                shuZi1xiaoShuChangDu = shuZi1[1].length();
                int count = shuZi1[1].length() - shuZi2[1].length();
                for (int m = 0; m < count; m++) {
                    num20 = num20 * 10;
                }
            } else {
                shuZi2xiaoShuChangDu = shuZi2[1].length();
                int count = shuZi2[1].length() - shuZi1[1].length();
                for (int n = 0; n < count; n++) {
                    num10 = num10 * 10;
                }
            }
            xiaoShuHe = num20 + num10;
            //如果小数部分相加大于原先最长长度说明有进位
            if (xiaoShuHe.toString().length() > (shuZi1xiaoShuChangDu + shuZi2xiaoShuChangDu)) {
                jinWei = xiaoShuHe.toString().substring(0, (xiaoShuHe.toString().length() - (shuZi1xiaoShuChangDu + shuZi2xiaoShuChangDu)));
            }
        } else {
            xiaoShuHe = num20 + num10;
        }
        numHe = num2 + num1;
        System.out.println("小数和=" + xiaoShuHe + "进位=" + jinWei);
        System.out.println("整数和=" + numHe);
        if (!jinWei.equals("0")) {
            numHe = numHe.intValue() + 1;
            String sum = numHe.toString() + "." + xiaoShuHe.toString().substring(1);
            zongHe = Double.parseDouble(sum);
        } else {
            String sum = numHe.toString() + "." + xiaoShuHe.toString();
            zongHe = Double.parseDouble(sum);
        }
        System.out.println("总和=" + zongHe);
    }

    public static void splitMoney(int unSplitMoney) {
        int unSplitMoneyCents = unSplitMoney;
        int[] splitArray = {100, 50, 20, 10, 5, 2, 1};
        String[] splitArrayName = {"100", "50", "20", "10", "5", "2", "1"};
        System.out.println("您的输入为:" + unSplitMoney + "可以被兑换为:");
        for (int i = 0; i < splitArray.length && unSplitMoneyCents > 0; i++) {
            if (unSplitMoneyCents >= splitArray[i]) {
                System.out.print(unSplitMoneyCents / splitArray[i] + "个" + splitArrayName[i] + ",");
                unSplitMoneyCents = unSplitMoneyCents % splitArray[i];
            }
        }
    }

    public static void splitMoney1(Double unSplitMoney) {
        int unSplitMoneyCents = (int) (unSplitMoney * 100);
        int[] splitArray = {100 * 100, 50 * 100, 20 * 100, 10 * 100, 5 * 100, 2 * 100, 1 * 100, 5 * 10, 2 * 10, 1 * 10, 5, 2, 1};
        String[] splitArrayName = {"100元", "50元", "20元", "10元", "5元", "2元", "1元", "5角", "2角", "1角", "5分", "2分", "1分"};
        System.out.println("您的输入金额为du:" + unSplitMoney + "元,可以被兑换为:");
        for (int i = 0; i < splitArray.length && unSplitMoneyCents > 0; i++) {
            if (unSplitMoneyCents >= splitArray[i]) {
                System.out.print(unSplitMoneyCents / splitArray[i] + "个" + splitArrayName[i] + ",");
                unSplitMoneyCents = unSplitMoneyCents % splitArray[i];
            }
        }
    }

    public static void main1(String[] args) {
        splitMoney(238);
    }

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        //将递归法的结束条件初始化为 1
        dp[len] = 1;
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
