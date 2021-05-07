package 计算机程序算法分类.数学问题;

import java.math.BigDecimal;

/**
 * @Classname average_double
 * @Description TODO
 * @Date 2021/5/3 21:17
 * @Created by xjl
 */
public class average_double {
    public static void main(String[] args) {
        float[] arr = new float[]{45.0f, 54.0f, 98.0f};

        System.out.println("**********************************************");
        System.out.println("出现的错误的方式"+test1(arr));
        System.out.println("**********************************************");

        System.out.println("完美解决的方法"+test3(arr));
        System.out.println("**********************************************");

        System.out.println("使用的BigDecimal函数的问题"+test2(arr));
        System.out.println("**********************************************");

    }

    public static float test1(float[] arr) {
        float sum = 0f;
        for (float f : arr) {
            sum += f;
        }
        float res = sum / arr.length;
        return res;
    }

    public static float test2(float[] arr) {
        float sum = 0f;
        for (float f : arr) {
            sum += f;
        }
        String res = new BigDecimal(sum).divide(new BigDecimal(arr.length)).toString();
        return Float.valueOf(res);
    }

    /**
     * @description TODO  原来JAVA中如果用BigDecimal做除法的时候一定要在divide方法中传递第二个参数，定义精确到小数点后几位，否则在不整除的情况下，结果是无限循环小数时，就会抛出以上异常
     * @param: arr
     * @date: 2021/5/7 9:37
     * @return: float
     * @author: xjl
     */
    public static BigDecimal test3(float[] arr) {
        float sum = 0f;
        for (float f : arr) {
            sum += f;
        }
        BigDecimal res = new BigDecimal(sum).divide(new BigDecimal(arr.length), 20, BigDecimal.ROUND_HALF_UP);
        return res;
    }
}
