/**
 * Copyright (C), 2018-2020
 * FileName: 一个数的平方根
 * Author:   xjl
 * Date:     2020/9/5 20:39
 * Description:
 */
package 数学问题;

public class 一个数的平方根 {

    public static void main(String[] args) {
        double sqrt = test(10, 0.02);
        System.out.println(sqrt);
    }

    public static double sqrt(double t, Double precise) {
        //采用的是二分法的思想来实现的
        double low = 0, high = t, middle, squre;
        double prec = precise != null ? precise : 1e-7;
        //小于的的时候是不能采取的
        if (t < 0) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }
        //判断的什么时候会达到精度要求。
        while (high - low > prec) {
            //中间值
            middle = (low + high) / 2;
            //中间值的平方
            squre = middle * middle;
            //如果是中间数字大于的话
            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }

    public static double sqrt2(double t, Double precise) {
        double x0 = t, x1, differ;
        double prec = precise != null ? precise : 1e-7;

        while (true) {
            x1 = (x0 * x0 + t) / (2 * x0);
            differ = x1 * x1 - t;

            if (differ <= prec && differ >= -prec) {
                return x1;
            }
            x0 = x1;
        }
    }

    public static float sqrtRoot(float m) {
        if (m == 0) {
            return 0;
        }
        float i = 0;
        float x1, x2 = 0;
        while ((i * i) <= m) {
            i += 0.1;
        }
        x1 = i;
        for (int j = 0; j < 10; j++) {
            x2 = m;
            x2 /= x1;
            x2 += x1;
            x2 /= 2;
            x1 = x2;
        }
        return x2;
    }

    /**
     * 这个为什么是的Double呢？ 因为是的如果是等空的时候
     *
     * @param t
     * @param precise
     */
    public static double test(double t, Double precise) {
        double low = 0, high = t, mid, square;
        double pre = precise != null ? precise : 1e-7;

        if (t < 0) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }
        while ((high - low) > pre) {
            mid = (high + low) / 2;
            square = mid * mid;
            if (square > t) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (high + low) / 2;
    }
}
