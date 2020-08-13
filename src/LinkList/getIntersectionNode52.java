/**
 * Copyright (C), 2018-2020
 * FileName: getIntersectionNode52
 * Author:   xjl
 * Date:     2020/8/12 19:21
 * Description:
 */
package LinkList;

import java.util.Stack;

public class getIntersectionNode52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        //链表入栈
        while (headA != null) {
            stack1.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stack2.add(headB);
            headB = headB.next;
        }
        //存结果
        ListNode ans = null;
        //遍历栈
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek()== stack2.peek()) {
                ans = stack1.peek();
                stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return ans;
    }

}
