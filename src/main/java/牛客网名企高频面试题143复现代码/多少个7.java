package 牛客网名企高频面试题143复现代码;

/**
 * @Classname 多少个7
 * @Description TODO
 * @Date 2020/12/22 12:23
 * @Created by xjl
 */
public class 多少个7 {
    public static void main(String[] args) {
        int count = 0;
        String result = "";
        long stime = System.currentTimeMillis(); // 记录起始时间
        for (int i = 1; i <= 100000; i++) {
            result += String.valueOf(i);
        }
        int start = 0;
        int end = result.length() - 1;

        while (start < end) {
            if (result.charAt(start) == '7') {
                count++;
            }
            if (result.charAt(end) == '7') {
                count++;
            }
            start++;
            end--;
        }
        long etime = System.currentTimeMillis();       // 记录结束时间
        System.out.println(count);
        System.out.println((etime - stime) / 1000);
    }
}
