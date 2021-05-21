package 计算机程序算法分类.字符串类型;

/**
 * @Classname 版本号的比较
 * @Description TODO
 * @Date 2021/5/20 20:38
 * @Created by xjl
 */
public class 版本号的比较 {
    /**
     * @description TODO 可以采用的递归的思想来解决方法
     * @param: s1
     * @param: s2
     * @date: 2021/5/20 21:12
     * @return: int
     * @author: xjl
     */
    public int compareTo(String s1, String s2) {
        int left = 0;
        int right = s1.indexOf(',');

        int left2 = 0;
        int right2 = s2.indexOf(',');
        if (s1.substring(left, right).equals(s2.substring(left2, right2))) {
            return s1.substring(left, right).compareTo(s2.substring(left2, right2));
        }
        return compareTo(s1.substring(right + 1), s2.substring(right2 + 1));
    }
}
