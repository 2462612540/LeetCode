/**
 * Copyright (C), 2018-2020
 * FileName: printListFromTailToHead
 * Author:   xjl
 * Date:     2020/3/23 16:06
 * Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class printListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();

        while (listNode != null) {
            list.add(listNode.val);

            listNode = listNode.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            list2.add(list.get(i));
        }
        return list2;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
//        for (int i=stack.size()-1;i>=0;i--){
//            list.add(stack.pop());
//        }
        return list;
    }

    @Test
    public void test3() {
        Stack stack = new Stack();
        //2.peek()栈顶值 3.进栈push()
        stack.push(1);
        stack.push("b");
        stack.push("c");

        while (!stack.empty()) {
            System.out.println("" + stack.pop());
        }
//        for (int i=0;i<3;i++){
//            System.out.println(stack.pop());
//        }
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(67);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(24);
        ListNode l4 = new ListNode(58);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(printListFromTailToHead2(l1));
    }

}





