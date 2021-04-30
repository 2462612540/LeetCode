package 计算机程序算法分类.工具类;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Classname DoubleUtil
 * @Description TODO
 * @Date 2021/4/27 11:37
 * @Created by xjl
 */
public class DoubleUtil {
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    /**#.## */
    public static final String REG_1 = "#.##";
    /** #,###.## */
    public static final String REG_2 = "#,###.##";

    // 这个类不能实例化
    private DoubleUtil() {
    }

    /**
     * 去掉科学记数法
     */
    public static String toStr(double v1) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        return b1.toPlainString();
    }

    /**
     * 主要用于格式化金额
     * @param v1 如：56,888,458,521
     * @return
     */
    public static String format(double v1) {
        NumberFormat numberFormat = new DecimalFormat(REG_2);
        String str = numberFormat.format(v1);
        return str;
    }

    /**
     * 主要用于格式化小数点
     * @param v1
     * @param reg
     * @return
     */
    public static String format(double v1,String reg) {
        NumberFormat numberFormat = new DecimalFormat(reg);
        String str = numberFormat.format(v1);
        return str;
    }


    /**
     * 加法
     */
    public static double add(double v1, double ...v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        for (double vv : v2){
            BigDecimal b2 = new BigDecimal(Double.toString(vv));
            b1=b1.add(b2);
        }
        return b1.doubleValue();
    }

    /**
     * 减法
     */
    public static double sub(double v1, double ...v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        for (double vv : v2){
            BigDecimal b2 = new BigDecimal(Double.toString(vv));
            b1=b1.subtract(b2);
        }

        return b1.doubleValue();
    }


    /**
     * 乘法运算。
     */
    public static double mul(double v1,double ...v2) {
        BigDecimal b1=new BigDecimal(Double.toString(v1));
        for (double vv : v2){
            BigDecimal b2 = new BigDecimal(Double.toString(vv));
            b1=b1.multiply(b2);
        }
        return b1.doubleValue();
    }
    /**
     *除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     public static double div(double v1, double ...v2) {
     return div(DEF_DIV_SCALE,v1, v2);
     } */

    /**
     * 提供（相对）精确的除法运算。
     */
    public static double div(double v1, double ...v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        for (double vv : v2){
            BigDecimal b2 = new BigDecimal(Double.toString(vv));
            b1=b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return b1.doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     */

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static String doubleWangFormatByObj(Object obj){
        return doubleWangFormatByObj(obj, "0");
    }

    public static String doubleWangFormatByObj(Object obj,String defaultValue){
        if(obj==null){
            return defaultValue;
        }else{
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(((Double)obj)/10000);
        }
    }

    public static String doubleFormatByObj(Object obj,String defaultValue){
        if(obj==null){
            return defaultValue;
        }else{
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(((Double)obj));
        }
    }

    public static void main(String[] args) {
        double sum=0;
        System.out.println(DoubleUtil.doubleFormatByObj(sum,"0.00"));
    }
}
