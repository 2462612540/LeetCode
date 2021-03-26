package 牛客网名企面试笔试问题2021;

/**
 * @Classname 判断是否为回文串
 * @Description TODO
 * @Date 2021/3/26 9:38
 * @Created by xjl
 */
public class 判断是否为回文串 {
    /**
     * @description TODO  典型的双指针方法
     * @param: str
     * @date: 2021/3/26 9:38
     * @return: boolean
     * @author: xjl
     */
    public boolean judge(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) == str.charAt(end--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
