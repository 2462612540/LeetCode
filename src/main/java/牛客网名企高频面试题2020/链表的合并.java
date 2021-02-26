package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.链表的合并
 * Author:   xjl
 * Date:     2020/9/13 21:09
 * Description:
 */

import org.junit.Test;

import java.util.ArrayList;

public class 链表的合并 {
    //定义节点
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dumpy = new ListNode(0);
        ListNode curr = dumpy;

        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                curr.next = head2;
                head2 = head2.next;
            } else {
                curr.next = head1;
                head1 = head1.next;
            }
            curr = curr.next;
        }
        while (head1 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
        }
        while (head2 != null) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
        }
        return dumpy.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(5);
        ListNode s3 = new ListNode(8);
        s1.next = s2;
        s2.next = s3;
        ListNode s4 = new ListNode(2);
        ListNode s5 = new ListNode(5);
        ListNode s6 = new ListNode(7);

        s4.next = s5;
        s5.next = s6;

        ListNode res = mergeTwoLists(s1, s4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    /**
     *  利用的归并的思想 两个两个合并来实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() < 1) return null;
        if (lists.size() == 1) return lists.get(0);
        if (lists.size() % 2 != 0) lists.add(null);
        ArrayList<ListNode> sum = new ArrayList<>();
        for (int i = 0; i < lists.size(); i += 2) {
            sum.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
        }
        return mergeKLists1(sum);
    }

}
