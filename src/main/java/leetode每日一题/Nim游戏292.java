package leetode每日一题;

/**
 * @Classname Nim游戏292
 * @Description TODO
 * @Date 2021/4/8 14:09
 * @Created by xjl
 */
public class Nim游戏292 {
    /**
     * @description TODO  数学的逻辑问题
     * @param: n
     * @date: 2021/4/8 14:22
     * @return: boolean
     * @author: xjl
     */
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        return (n % 4 != 0);
    }

    /**
     * @description TODO 递归的方法 这个是的溢出的
     * @param: n
     * @date: 2021/4/8 14:21
     * @return: boolean
     * @author: xjl
     */
    public boolean canWinNim2(int n) {
        if (n <= 3) {
            return true;
        }
        return !canWinNim2(n - 1) || !canWinNim2(n - 2) || !canWinNim2(n - 3);
    }

    /**
     * @description TODO 还是出现了的溢出问题
     * @param: n
     * @date: 2021/4/8 14:25
     * @return: boolean
     * @author: xjl
     */
    public boolean canWinNim3(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] canwin = new boolean[n + 1];
        canwin[1] = true;
        canwin[2] = true;
        canwin[3] = true;
        for (int i = 4; i <= n; i++) {
            canwin[i] = !canwin[i - 1] || !canwin[i - 2] || !canwin[i - 3];
        }
        return canwin[n];
    }


}
