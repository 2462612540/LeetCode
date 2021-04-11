package leetode每日一题;

/**
 * @Classname 丑数III264
 * @Description TODO
 * @Date 2021/4/11 10:27
 * @Created by xjl
 */
public class 丑数III264 {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;

        int[] res = new int[n];
        res[0] = 1;

        int two = 0;
        int three = 0;
        int five = 0;

        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[two] * 2, Math.min(res[three] * 3, res[five] * 5));
            if (res[i] == res[two] * 2) {
                two++;
            }
            if (res[i] == res[three] * 3) {
                three++;
            }
            if (res[i] == res[five] * 5) {
                five++;
            }
        }
        return res[n - 1];
    }
}
