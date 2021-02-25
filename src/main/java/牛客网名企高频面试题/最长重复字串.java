package 牛客网名企高频面试题;

/**
 * @Classname 最长重复字串
 * @Description TODO
 * @Date 2020/12/13 15:52
 * @Created by xjl
 */
public class 最长重复字串 {

    public int solve(String a) {
        int len = a.length();
        for (int dis = len / 2; dis > 0; dis--) {
            int maxIndex = len - 1 - dis;
            int count = 0;
            for (int index = 0; index <= maxIndex; index++) {
                if (a.charAt(index) == a.charAt(index + dis)) {
                    count++;
                    if (count == dis) break;
                } else {
                    count = 0;
                }
            }
            if (count == dis) return 2 * dis;
        }
        return 0;
    }
}
