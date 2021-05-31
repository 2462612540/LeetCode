package leetode每日一题;

/**
 * @Classname four幂342
 * @Description TODO
 * @Date 2021/5/31 10:25
 * @Created by xjl
 */
public class four幂342 {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
