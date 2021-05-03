package 计算机程序算法分类.数学问题;

import org.junit.Test;

/**
 * @Classname 整数反转7
 * @Description TODO
 * @Date 2021/5/3 20:43
 * @Created by xjl
 */
public class 整数反转7 {
    //采用的传统的方法来进行的判断
    int reverse(int x) {
        String res = String.valueOf(x);
        if (res.charAt(0) == '-') {
            res = res.substring(1);
        }
        String str = new StringBuilder(res).reverse().toString();
        if (Double.valueOf(str) > Integer.MAX_VALUE || Integer.MIN_VALUE > Double.valueOf(str)) {
            return 0;
        }
        if (x < 0) {
            return -Integer.valueOf(str);
        } else {
            return Integer.valueOf(str);
        }
    }

    public int reverse2(int x) {
        long result = 0;
        //将数字分别取出来放入在list中
        do {
            result = result * 10 + (x % 10);//这里加1后突破了int类型
            x = x / 10;//取出剩下的结果放入x中
            if(result> Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            {
                return 0;
            }
        } while (x != 0);//这个的判断条件有问题
        return (int)result;
    }



    @Test
    public void test() {
        int reverse = reverse(-2147483648);
        System.out.println(reverse);
    }
}
