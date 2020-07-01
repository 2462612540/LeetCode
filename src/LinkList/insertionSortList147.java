/**
 * Copyright (C), 2018-2020
 * FileName: insertionSortList147
 * Author:   xjl
 * Date:     2020/6/29 10:13
 * Description: 147. 对链表进行插入排序
 */
package LinkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class insertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        ListNode res = new ListNode(0);
        ListNode pre = res;

        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(list);
        for (int V : list) {
            pre.next = new ListNode(V);
            pre = pre.next;
        }
        return res.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(6);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(4);
        ListNode s6 = new ListNode(5);
        ListNode s7 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        ListNode node = insertionSortList(s1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
