package 复现代码;

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
        for (int i = 1; i <= 1000; i++) {
            result += String.valueOf(i);
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '7') {
                count++;
            }
        }
        System.out.println(result);
        System.out.println(count);
    }
}
