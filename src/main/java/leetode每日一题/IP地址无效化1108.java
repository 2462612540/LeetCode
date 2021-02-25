package leetode每日一题;

import org.junit.Test;

/**
 * @Classname IP地址无效化1108
 * @Description TODO
 * @Date 2020/12/30 10:10
 * @Created by xjl
 */
public class IP地址无效化1108 {
    /**
     * @description TODO  所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。 当然是的类采用的二分法的方式来保持的这样的方法。
     * @param: address
     * @date: 2020/12/30 10:10
     * @return: java.lang.String
     * @author: xjl
     */
    public static String defangIPaddr(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                result += address.charAt(i);
            } else {
                result += "[.]";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = defangIPaddr("255.100.50.0");
        System.out.println(s);
    }

}
