package leetode每日一题;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname 反转每对括号间的子串1190
 * @Description TODO
 * @Date 2021/5/26 10:57
 * @Created by xjl
 */
public class 反转每对括号间的子串1190 {

    @Test
    public void test() {
        String str = "(u(love)i)";
        String s = reverseParentheses(str);
        System.out.println(s);
    }

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
