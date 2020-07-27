/**
 * Copyright (C), 2018-2020
 * FileName: printListFromTailToHead
 * Author:   xjl
 * Date:     2020/7/16 14:49
 * Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
package LinkList;

import java.util.ArrayList;
import java.util.Stack;

public class printListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //出栈
        while (!stack.isEmpty()) {
            list.add(stack.peek());
            stack.pop();
        }
        return list;
    }

}
