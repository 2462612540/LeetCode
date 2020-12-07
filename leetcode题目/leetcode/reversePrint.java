/**
 * Copyright (C), 2018-2020
 * FileName: reversePrint
 * Author:   xjl
 * Date:     2020/4/1 11:42
 * Description: 从尾到头打印链表
 */
package leetcode;

import java.util.Stack;

public class reversePrint {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 采用的是stack 这样的方式 或许也可以采用是链表的翻转 来讲数据入到到数组中
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int num = stack.size();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

}
