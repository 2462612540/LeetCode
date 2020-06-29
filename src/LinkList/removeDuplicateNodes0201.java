/**
 * Copyright (C), 2018-2020
 * FileName: removeDuplicateNodes0201
 * Author:   xjl
 * Date:     2020/6/26 20:10
 * Description: 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
package LinkList;

import org.junit.Test;

import java.util.ArrayList;

public class removeDuplicateNodes0201 {

    //删除连续的重复的元素
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode curr = node;
        ListNode pre = head;

        curr.next = pre;

        while (pre.next != null) {
            if (pre.val == pre.next.val) {
                curr.next = pre.next;
                pre = pre.next;
                continue;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return node.next;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pre = head;
        while (pre != null) {
            if (!list.contains(pre.val)) {
                list.add(pre.val);
            }
            pre = pre.next;
        }
        ListNode res = new ListNode(0);
        ListNode pre1 = res;
        for (int V : list) {
            pre1.next = new ListNode(V);
            pre1 = pre1.next;
        }
        return res.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(2);
        ListNode s6 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        ListNode listNode = removeDuplicateNodes1(s1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
