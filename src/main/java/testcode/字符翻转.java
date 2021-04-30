package testcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname 字符翻转
 * @Description TODO
 * @Date 2021/4/16 20:31
 * @Created by xjl
 */
public class 字符翻转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String reverse = reverse(str);
        System.out.println(reverse);
    }

    private static String reverse(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String current = str.charAt(i) + "";
            if (" ".equals(current)) {
                if (i == 0) {
                    stringBuffer.append(" ");
                } else if (stack.size() != 0) {
                    while (stack.size() != 0) {
                        stringBuffer.append(stack.pop());
                    }
                    stringBuffer.append(" ");
                }
            } else {
                stack.push(current);
            }
        }
        if (stack.size() != 0) {
            while (stack.size() != 0) {
                stringBuffer.append(stack.pop());
            }
        }
        return stringBuffer.toString();
    }
}
