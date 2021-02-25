/**
 * Copyright (C), 2018-2020
 * FileName: ListNodeMerge
 * Author:   xjl
 * Date:     2020/5/8 20:12
 * Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListNodeMerge {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        System.out.println(list.toString());
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        System.out.println(list.toString());
        for (int va : list) {
            curr.next = new ListNode(va);
            curr = curr.next;
        }
        return pre.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prehead.next;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;

        ListNode res = Merge(s1, n1);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
