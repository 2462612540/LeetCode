/**
 * Copyright (C), 2018-2020
 * FileName: lengthOfLastWord
 * Author:   xjl
 * Date:     2020/3/1 9:00
 * Description: 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。  如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。  如果不存在最后一个单词，请返回 0 。
 */
package simple_difficulty;

/**
 * 将字符串转发成为字符数组
 * 遍历字符数组如果遇见空字符则记录当前数字并赋值给reslut
 * 在后面的遍历的过程中依次操作，每次记录这个数字并与最大的比较，
 * 如果是大于前面的数组则将新的值赋予给result 如果小于的则不选择赋值
 * 直到最后的遍时候判断当前记录的数字否大于最大的数字
 */
public class lengthOfLastWord {
    public static  int lengthOfLastWord(String s) {
        return 0;
    }
    public static void main(String[] args) {
        String s="this afasfa";
        System.out.println(lengthOfLastWord(s));

    }
}
