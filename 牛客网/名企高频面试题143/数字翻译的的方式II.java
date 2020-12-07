package 名企高频面试题143;

/**
 * @Classname 名企高频面试题143.数字翻译的的方式II
 * @Description TODO
 * @Date 2020/12/7 14:36
 * @Created by xjl
 */
public class 数字翻译的的方式II {

    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int currentNum = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                if (i - 2 < 0) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i];
            int currentNum = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[len];
    }

    /**
     * @description TODO 采用的是的dfs的算法实现
     * @param: num
     * @date: 2020/12/7 15:08
     * @return: int
     * @author: xjl
     */
    public int translateNum2(int num) {
        //将字符串转化为数字
        String str = String.valueOf(num);
        //dfs遍历字符串求解
        return dfs(str, 0);
    }

    //表示从index位置开始有好多种翻译方法
    public int dfs(String str, int index) {
        //如果当前的下标大于等于字符串的长度 - 1，则说明当前位置是由上一次跳到此处的，则直接返回1
        if (index >= str.length() - 1)
            return 1;
        //先求解每一次都翻译一个字符的方法数
        int res = dfs(str, index + 1);
        //以当前字符的下标为开始，截取两位，判断这位组成的数字是否在10~25之间
        //如果在这一次就可以直接翻译两个字符，然后从两个字符后面的位置开始翻译
        String temp = str.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
            res += dfs(str, index + 2);
        return res;
    }
}
