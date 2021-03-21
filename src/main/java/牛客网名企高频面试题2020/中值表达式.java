package 牛客网名企高频面试题2020;

import java.util.Stack;

/**
 * @Classname 中值表达式
 * @Description TODO
 * @Date 2020/12/17 15:40
 * @Created by xjl
 */
public class 中值表达式 {

    public int solve(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sum = 0;
        char sign = '+';
        char[] c = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ele = c[i];
            if (Character.isDigit(ele)) {
                number = number * 10 + ele - '0';
            }
            if (ele == '(') {
                int j = i + 1;
                int counterPar = 1;
                String subPar = "";
                //extract the most outer group and recursevely preocess
                while (counterPar > 0) {
                    if (c[j] == '(') {
                        counterPar++;
                    }
                    if (c[j] == ')') {
                        counterPar--;
                    }
                    j++;
                }
                subPar = s.substring(i + 1, j - 1);
                number = solve(subPar);
                i = j - 1;
            }
            if (ele != ' ' && !Character.isDigit(ele) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = ele;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
